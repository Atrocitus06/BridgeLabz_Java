package DataStructure.LinkedList;
/*
RoundRobinScheduling
This standalone Java class (no package) implements FULL circular singly linked list for Round Robin CPU scheduling.

NODE STRUCTURE:
ProcessNode: pid(int unique), burst(int remaining burst time), priority(int), next(ProcessNode)
Circular: head -> ... -> last.next = head (head null=empty)

LIST MAINTENANCE:
head: current process to execute (starts null)
remainingBurst: decrements by quantum each turn; 0=completed
Traverse circularly using do-while until back to head

CORE OPERATIONS:
1. addProcess(): Appends to end (find last via circular traverse) O(n)
2. removeByPid(pid): Finds/deletes node, fixes circular links O(n)
3. displayQueue(): Prints all processes circularly from head O(n)
4. simulateRR(quantum): Full simulation - cycles current=head, executes quantum or remaining, removes if done, moves to next; collects stats
5. calculateAverages(): Computes avg waiting=(sum turnaround - burst)/count, avg turnaround=sum(CT - AT)/count (assumes AT=0)

SIMULATION LOGIC:
- Menu adds processes (user inputs pid>0 unique, burst>0, priority 1-10)
- Fixed quantum=2 (as common example)
- Simulate: Start from head, for each process: min(quantum, remaining), print "Executing P<pid> for <time>", update time/remaining
- If remaining==0 post-quantum: remove, record CT=time
- Next = current.next (circular)
- After all or manual stop: compute/print avgs (AT=add time approx 0 for simplicity)
- Handles empty list, single process, uneven bursts

COMPLEXITIES:
   Operation          Complexity
   addProcess         O(n) traverse
   removeByPid        O(n) search+unlink
   display            O(n)
   simulateRR         O(total_burst / quantum * n) worst
   averages           O(1) post-stats

EDGE CASES:
- Empty list: safe null checks
- Single process: executes fully in one go
- All burst < quantum: quick completes
- Duplicate pid: rejects add
- Remove non-existent: prints message
- Priority stored but not used in scheduling (per problem, RR ignores prio)

COMPILE/RUN: javac RoundRobinScheduling.java && java RoundRobinScheduling
Menu: 1=add proc, 2=display, 3=simulate (prompts quantum), 4=avgs, 0=exit
Test: Add P1 burst10 prio5, P2 b6 p3, P3 b8 p7; simulate q=2 -> see rotations/executions/CTs/avgs

Full RR with circular list, stats, menu - interview-ready!
*/

import java.util.Scanner;

public class RoundRobinScheduling {
    static class ProcessNode {
        int pid;
        int burst;  // remaining burst time
        int priority;
        ProcessNode next;

        ProcessNode(int p, int b, int pr) {
            pid = p;
            burst = b;
            priority = pr;
            next = null;
        }
    }

    ProcessNode head;  // current to execute
    double totalTurnaround;
    double totalBurst;  // for waiting time calc
    int completedCount;

    public RoundRobinScheduling() {
        head = null;
        totalTurnaround = 0;
        totalBurst = 0;
        completedCount = 0;
    }

    // Add new process at end (circular append)
    void addProcess(int pid, int burst, int priority) {
        if (burst <= 0) {
            System.out.println("Burst must be >0!");
            return;
        }
        ProcessNode newNode = new ProcessNode(pid, burst, priority);
        if (head == null) {
            head = newNode;
            newNode.next = head;  // circular
        } else {
            ProcessNode last = head;
            // Traverse to last (before back to head)
            do {
                last = last.next;
            } while (last.next != head);
            last.next = newNode;
            newNode.next = head;  // close circle
        }
        totalBurst += burst;
        System.out.println("Added P" + pid + " (burst=" + burst + ", prio=" + priority + ")");
    }

    // Remove by pid, fix circular links
    void removeByPid(int pid) {
        if (head == null) {
            System.out.println("Empty queue!");
            return;
        }
        if (head.pid == pid) {  // head case
            ProcessNode last = head;
            do {
                last = last.next;
            } while (last.next != head);
            if (head.next == head) {  // single
                head = null;
            } else {
                last.next = head.next;
                head = head.next;
            }
            System.out.println("Removed P" + pid);
            return;
        }
        ProcessNode curr = head.next;
        ProcessNode prev = head;
        while (curr != head) {
            if (curr.pid == pid) {
                prev.next = curr.next;
                System.out.println("Removed P" + pid);
                return;
            }
            prev = curr;
            curr = curr.next;
        }
        System.out.println("P" + pid + " not found!");
    }

    // Display circular queue from head
    void displayQueue() {
        if (head == null) {
            System.out.println("Queue empty!");
            return;
        }
        ProcessNode curr = head;
        System.out.print("Queue: ");
        do {
            System.out.print("P" + curr.pid + "(" + curr.burst + "/" + curr.priority + ") -> ");
            curr = curr.next;
        } while (curr != head);
        System.out.println("(circular)");
    }

    // Simulate one full RR cycle with given quantum
    // Updates remaining, removes done, collects CT (assumes AT=0)
    void simulateRR(int quantum) {
        if (head == null) {
            System.out.println("No processes!");
            return;
        }
        int time = 0;
        ProcessNode current = head;
        boolean allDone = false;
        while (!allDone) {
            allDone = true;
            ProcessNode start = current;
            do {
                if (current.burst > 0) {  // alive
                    allDone = false;
                    int execTime = Math.min(quantum, current.burst);
                    time += execTime;
                    current.burst -= execTime;
                    System.out.println("Time " + time + ": Executed P" + current.pid + " for " + execTime + " (rem=" + current.burst + ")");
                    if (current.burst == 0) {
                        // Record CT=time, remove after print
                        totalTurnaround += time;  // TAT = CT - AT ≈ CT
                        completedCount++;
                        int targetPid = current.pid;
                        current = current.next;
                        removeByPid(targetPid);  // removes prev current
                        // head may change, but we continue from next
                    } else {
                        current = current.next;
                    }
                } else {
                    current = current.next;
                }
            } while (current != start && head != null);  // one full circle or empty
            if (head == null) break;
        }
        System.out.println("Simulation complete. Total time: " + time);
    }

    // Calculate and display averages (post-simulation)
    void calculateAverages() {
        if (completedCount == 0) {
            System.out.println("No completed processes!");
            return;
        }
        double avgTurnaround = totalTurnaround / completedCount;
        double avgWaiting = (totalTurnaround - totalBurst) / completedCount;
        System.out.println("Average Turnaround Time: " + String.format("%.2f", avgTurnaround));
        System.out.println("Average Waiting Time: " + String.format("%.2f", avgWaiting));
    }

    public static void main(String[] args) {
        RoundRobinScheduling rr = new RoundRobinScheduling();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n--- Round Robin Scheduler ---");
            System.out.println("1. Add Process");
            System.out.println("2. Display Queue");
            System.out.println("3. Simulate RR (prompt quantum)");
            System.out.println("4. Show Averages");
            System.out.println("0. Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("PID (>0 unique): ");
                    int pid = sc.nextInt();
                    System.out.print("Burst Time (>0): ");
                    int burst = sc.nextInt();
                    System.out.print("Priority (1-10): ");
                    int prio = sc.nextInt();
                    rr.addProcess(pid, burst, prio);
                    break;
                case 2:
                    rr.displayQueue();
                    break;
                case 3:
                    System.out.print("Time Quantum: ");
                    int q = sc.nextInt();
                    rr.simulateRR(q);
                    break;
                case 4:
                    rr.calculateAverages();
                    break;
                case 0:
                    System.out.println("Exiting.");
                    break;
                default:
                    System.out.println("Invalid! 0-4 only.");
            }
        } while (choice != 0);
        sc.close();
    }
}
/* END - Complete Round Robin with circular linked list, simulation, stats. Test with adds then simulate q=2! */
