package algol0213;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 이나연 {
	static int T,N,min,max;
	static int[] arr= new int[4],nums,visited= new int[4],result;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t < T+1; t++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			nums = new int[N];
			result = new int[N-1];
			Arrays.fill(result, -1);
			min=Integer.MAX_VALUE;
			max=Integer.MIN_VALUE;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			//System.out.println(Arrays.toString(nums));
			
			perm(0);
			//System.out.println("max="+max + "min="+min);
			System.out.println("#"+t+" "+(max-min));
		}

}
	static void perm(int cnt) {
		if(cnt == N-1) {
			//System.out.println(Arrays.toString(result));
			cal();
			return;
		}
		for (int i = 0; i < 4; i++) {
			if(visited[i] == arr[i]) continue;
			visited[i] +=1;
			result[cnt] =i;
			perm(cnt+1);
			visited[i] -=1;
			result[cnt] = -1;
		}
	}
	static void cal() {
		int answer = nums[0] ;
		for (int i = 0; i < N-1; i++) {
			if(result[i] == 0) {
				answer += nums[i+1];
				
			}else if(result[i] == 1) {
				answer -= nums[i+1];
			}else if(result[i] == 2) {
				answer *= nums[i+1];
			}else {
				answer /= nums[i+1];
			} 
		}
		//System.out.println(answer);
		if(min > answer) min = answer;
		if(max < answer) max = answer;
	}
}
