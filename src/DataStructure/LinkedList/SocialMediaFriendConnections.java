package DataStructure.LinkedList;
/*
SocialMediaFriendConnections
This standalone Java class (no package) implements FULL singly linked list for social media friend connections management.

NODE STRUCTURE:
UserNode: userId(int unique), name(String), age(int), friends(UserNode nested singly linked list of friend IDs? Wait - friends are IDs, so FriendNode inner for friends list)
- Main list: head -> users (userId unique key)
- Each user has friendsHead: -> FriendNode(id) -> ... null
FriendNode: int friendId; FriendNode next;  // simple ID list per user

LIST MAINTENANCE:
head: first user (null=empty)
addUser implicit via connections (but add single first)
Friends: bidirectional? No, problem says "friend connection" mutual, so add both directions A.friends add B.id AND B.friends add A.id

CORE OPERATIONS:
1. addUser(id, name, age): Adds/appends user O(n), creates empty friends
2. addFriendConnection(id1, id2): Finds both users O(n), adds id2 to id1.friends O(1 tail), id1 to id2.friends O(1); rejects self/dupe
3. removeFriendConnection(id1, id2): Finds both, removes id2 from id1.friends O(n friends), id1 from id2 O(n);
4. mutualFriends(id1, id2): Finds users, traverses both friends lists O(f1 + f2), counts common IDs (no dupes assumed)
5. displayFriends(userId): Finds user O(n), prints all friendIds O(f)
6. searchUser(id/name): Linear scan O(n), prints matching users
7. countFriends(userId): Finds user O(n), counts friends list length O(f)
Bonus: displayAllUsersFriends(): All users + their friend counts/lists

COMPLEXITIES: (n=users ~10-50 interview, f=friends avg 5-10)
   Operation              Main List   Friends
   addUser                O(n)
   addConnection          O(n)        O(1)
   removeConnection       O(n)        O(f)
   mutualFriends          O(n)        O(f1+f2)
   displayFriends         O(n)        O(f)
   searchUser             O(n*f? no)  O(n)
   countFriends           O(n)        O(f)

EDGE CASES:
- Empty list: safe
- User not found: print msg, skip
- Self-friend: reject
- Dupe connection: check exists before add
- Mutual count: 0 if no common
- Friends list empty: 0 friends
- Remove non-friend: no-op msg

COMPILE/RUN: javac SocialMediaFriendConnections.java && java SocialMediaFriendConnections
Menu: 1=addUser, 2=addFriend(id1 id2), 3=removeFriend(id1 id2), 4=mutual(id1 id2), 5=displayFriends(id), 6=search(id/name), 7=countFriends(id), 8=all, 0=exit
Test: addU 1 Alice 25, addU 2 Bob 30, addU 3 Charlie 28; addF 1 2, addF 1 3, addF 2 3; mutual 1 2 ->1 (Charlie), etc.

Full bidirectional friends graph via ID lists in users linked list - perfect for interviews!
*/

import java.util.Scanner;

public class SocialMediaFriendConnections {
    static class FriendNode {
        int friendId;
        FriendNode next;

        FriendNode(int id) {
            friendId = id;
            next = null;
        }
    }

    static class UserNode {
        int userId;
        String name;
        int age;
        FriendNode friendsHead;  // head of friends list
        UserNode next;

        UserNode(int id, String n, int a) {
            userId = id;
            name = n;
            age = a;
            friendsHead = null;
            next = null;
        }
    }

    UserNode head;

    public SocialMediaFriendConnections() {
        head = null;
    }

    // Add/append user (if exists, update name/age optional)
    void addUser(int id, String name, int age) {
        UserNode newUser = new UserNode(id, name, age);
        if (head == null) {
            head = newUser;
        } else {
            UserNode last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newUser;
        }
        System.out.println("Added user " + id + ": " + name + " (" + age + ")");
    }

    // Find user by id, return node or null
    UserNode findUser(int id) {
        UserNode curr = head;
        while (curr != null) {
            if (curr.userId == id) return curr;
            curr = curr.next;
        }
        return null;
    }

    // Check if friendId exists in user's friends list
    boolean hasFriend(UserNode user, int friendId) {
        FriendNode f = user.friendsHead;
        while (f != null) {
            if (f.friendId == friendId) return true;
            f = f.next;
        }
        return false;
    }

    // Append friendId to user's friends (no dupe)
    void addFriendToUser(UserNode user, int friendId) {
        if (hasFriend(user, friendId)) {
            return;  // dupe
        }
        FriendNode newF = new FriendNode(friendId);
        if (user.friendsHead == null) {
            user.friendsHead = newF;
        } else {
            FriendNode last = user.friendsHead;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newF;
        }
    }

    // Remove friendId from user's friends
    void removeFriendFromUser(UserNode user, int friendId) {
        if (user.friendsHead == null) return;
        if (user.friendsHead.friendId == friendId) {
            user.friendsHead = user.friendsHead.next;
            return;
        }
        FriendNode prev = user.friendsHead;
        FriendNode curr = prev.next;
        while (curr != null) {
            if (curr.friendId == friendId) {
                prev.next = curr.next;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    // Add mutual friend connection
    void addFriendConnection(int id1, int id2) {
        if (id1 == id2) {
            System.out.println("Cannot friend self!");
            return;
        }
        UserNode u1 = findUser(id1);
        UserNode u2 = findUser(id2);
        if (u1 == null) {
            System.out.println("User " + id1 + " not found!");
            return;
        }
        if (u2 == null) {
            System.out.println("User " + id2 + " not found!");
            return;
        }
        addFriendToUser(u1, id2);
        addFriendToUser(u2, id1);
        System.out.println("Added connection: " + id1 + " <-> " + id2);
    }

    // Remove mutual friend connection
    void removeFriendConnection(int id1, int id2) {
        UserNode u1 = findUser(id1);
        UserNode u2 = findUser(id2);
        if (u1 == null || u2 == null) {
            System.out.println("One/both users not found!");
            return;
        }
        removeFriendFromUser(u1, id2);
        removeFriendFromUser(u2, id1);
        System.out.println("Removed connection: " + id1 + " - " + id2);
    }

    // Count mutual friends
    int mutualFriends(int id1, int id2) {
        UserNode u1 = findUser(id1);
        UserNode u2 = findUser(id2);
        if (u1 == null || u2 == null) {
            System.out.println("One/both users not found!");
            return 0;
        }
        int count = 0;
        FriendNode f1 = u1.friendsHead;
        while (f1 != null) {
            if (hasFriend(u2, f1.friendId)) {
                count++;
            }
            f1 = f1.next;
        }
        return count;
    }

    // Display all friends of user
    void displayFriends(int id) {
        UserNode user = findUser(id);
        if (user == null) {
            System.out.println("User " + id + " not found!");
            return;
        }
        System.out.print("Friends of " + user.name + "(" + id + "): ");
        FriendNode f = user.friendsHead;
        if (f == null) {
            System.out.println("none");
            return;
        }
        while (f != null) {
            System.out.print(f.friendId + " ");
            f = f.next;
        }
        System.out.println();
    }

    // Search by id or partial name
    void searchUser(int id, String name) {
        UserNode curr = head;
        boolean found = false;
        while (curr != null) {
            if (id != -1 && curr.userId == id) {
                System.out.println("Found: " + curr.userId + " - " + curr.name + "(" + curr.age + "), Friends: " + countFriends(curr.userId));
                found = true;
            } else if (name != null && curr.name.toLowerCase().contains(name.toLowerCase())) {
                System.out.println("Found: " + curr.userId + " - " + curr.name + "(" + curr.age + "), Friends: " + countFriends(curr.userId));
                found = true;
            }
            curr = curr.next;
        }
        if (!found) {
            System.out.println("No match!");
        }
    }

    // Count friends for user
    int countFriends(int id) {
        UserNode user = findUser(id);
        if (user == null) {
            System.out.println("User not found!");
            return 0;
        }
        int count = 0;
        FriendNode f = user.friendsHead;
        while (f != null) {
            count++;
            f = f.next;
        }
        System.out.println(user.name + "(" + id + ") has " + count + " friends.");
        return count;
    }

    // Display all users and their friends/count
    void displayAll() {
        UserNode curr = head;
        if (curr == null) {
            System.out.println("No users!");
            return;
        }
        while (curr != null) {
            System.out.print(curr.userId + " " + curr.name + "(" + curr.age + ") friends(" + countFriends(curr.userId) + "): ");
            FriendNode f = curr.friendsHead;
            while (f != null) {
                System.out.print(f.friendId + " ");
                f = f.next;
            }
            System.out.println();
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        SocialMediaFriendConnections sm = new SocialMediaFriendConnections();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n--- Social Media Friends ---");
            System.out.println("1. Add User (id name age)");
            System.out.println("2. Add Friend Conn (id1 id2)");
            System.out.println("3. Remove Friend (id1 id2)");
            System.out.println("4. Mutual Friends (id1 id2)");
            System.out.println("5. Display Friends (id)");
            System.out.println("6. Search (id or name, -1/empty for name)");
            System.out.println("7. Count Friends (id)");
            System.out.println("8. Display All");
            System.out.println("0. Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();
            sc.nextLine();  // clear
            switch (choice) {
                case 1:
                    System.out.print("ID: "); int id1 = sc.nextInt(); sc.nextLine();
                    System.out.print("Name: "); String n = sc.nextLine();
                    System.out.print("Age: "); int a = sc.nextInt();
                    sm.addUser(id1, n, a);
                    break;
                case 2:
                    System.out.print("ID1: "); int f1 = sc.nextInt();
                    System.out.print("ID2: "); int f2 = sc.nextInt();
                    sm.addFriendConnection(f1, f2);
                    break;
                case 3:
                    System.out.print("ID1: "); int r1 = sc.nextInt();
                    System.out.print("ID2: "); int r2 = sc.nextInt();
                    sm.removeFriendConnection(r1, r2);
                    break;
                case 4:
                    System.out.print("ID1: "); int m1 = sc.nextInt();
                    System.out.print("ID2: "); int m2 = sc.nextInt();
                    int mut = sm.mutualFriends(m1, m2);
                    System.out.println("Mutual friends: " + mut);
                    break;
                case 5:
                    System.out.print("User ID: "); int d = sc.nextInt();
                    sm.displayFriends(d);
                    break;
                case 6:
                    System.out.print("ID (-1 for name): "); int sid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name (empty for id): "); String sn = sc.nextLine();
                    sm.searchUser(sid == -1 ? -1 : sid, sn.isEmpty() ? null : sn);
                    break;
                case 7:
                    System.out.print("User ID: "); int c = sc.nextInt();
                    sm.countFriends(c);
                    break;
                case 8:
                    sm.displayAll();
                    break;
                case 0:
                    System.out.println("Bye!");
                    break;
                default:
                    System.out.println("Invalid 0-8!");
            }
        } while (choice != 0);
        sc.close();
    }
}
/* END - Complete social friends with singly linked users + nested friends lists, all ops mutual/bidir. Test connections/mutuals! */

