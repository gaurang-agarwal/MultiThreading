package hackerearth;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * After getting her PhD, Christie has become a celebrity at her university, and her facebook profile is full of friend requests. Being the nice girl she is, Christie has accepted all the requests.

Now Kuldeep is jealous of all the attention she is getting from other guys, so he asks her to delete some of the guys from her friend list.

To avoid a 'scene', Christie decides to remove some friends from her friend list, since she knows the popularity of each of the friend she has, she uses the following algorithm to delete a friend.

Algorithm Delete(Friend):
    DeleteFriend=false
    for i = 1 to Friend.length-1
         if (Friend[i].popularity < Friend[i+1].popularity)
            delete i th friend
            DeleteFriend=true
            break
    if(DeleteFriend == false)
        delete the last friend

Input:
First line contains T number of test cases. First line of each test case contains N, the number of friends Christie currently has and K ,the number of friends Christie decides to delete. Next lines contains popularity of her friends separated by space.

Output:
For each test case print N-K numbers which represent popularity of Christie friend's after deleting K friends. 
 */
public class DeleteFriends {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0;i<T;i++)
		{
			int N = sc.nextInt();
			long K = sc.nextLong();
			List<Integer> friendList = new ArrayList<>(N);
			for(int n=0;n<N;n++)
			{
				friendList.add(sc.nextInt());
			}
			deleteFriend(friendList, 0, K);
			friendList.stream().forEach(e -> {System.out.print(e+" ");});
			System.out.println();
		}
		
	}

	
	private static void deleteFriend(List<Integer> friendList,long deleted,long target)
	{
		int i=0;
		while(target>deleted)
		{
			boolean isDeleted=false;
			for(;i<friendList.size()-1;i++)
			{
				if(friendList.get(i) < friendList.get(i+1))
				{
					friendList.remove(i);
					isDeleted=true;
					if(i>0)
						i--;
					
					break;
				}
			}
			if(!isDeleted)
				friendList.remove(friendList.size()-1);
			
			deleted++;
		}
	}
	
}
