package Game_System;

public class Game{
	
	public int box[][] = {
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,1,2,0,0,0,0},
			{0,0,0,0,2,1,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0}};
	
	int player = 1;
	int b_coin = 0;
	int w_coin = 0;
	int w_box = 0;
	int b_box = 0;
	boolean turnPass = false;
	boolean winJudge = false;
	
	
	Shadow sa = new Shadow();
	
	public void gameStart(int x, int y){

		Music clickmusic = new Music("클릭소리.mp3",false);
		Music cantmusic = new Music("pi.mp3",false);
		
		turnPass = false;
		int count = 0 ; // 뒤집을꺼 유무 확인
		int judge = 0; // 나둘 수 있는 곳인지 판단
		b_coin = 0; //블랙코인 갯수
		w_coin = 0; // 화이트 코인 갯수
		w_box = 0;
		b_box = 0;
		int shadow_count = 0; // 나둘 수 있는 곳 카운트
		boolean last_Judge = false; 
		sa.shadow_countdown(box, player);

//----------------------------------------------------------------------------
		
		if(box[x][y] != 0 && box[x][y] != 3) {
			cantmusic.start();
			System.out.println("나둘 수 없는 곳입니다.");
			for(int i = 1; i <= 8 ; i ++) {
				for(int j = 1; j <= 8; j ++) {
					if(box[i][j] == 1) {
						w_box ++;
					}else if(box[i][j] == 2) {
						b_box ++;
					}
				}
			}
			b_coin = b_box;
			w_coin = w_box;
			return;
		}
		
		if(box[x-1][y] != 0&&x>=3&&box[x-1][y] != 3) {  //나두는 곳 (위) 판단
			last_Judge = false;count = 0;
			for(int i = x-1; i >= 1; i--) {
				if(box[i][y] == 0 || box[i][y] == 3) {
					count = 0;
					break;
				}else if(box[i][y] != player) {
					count ++; 
				}else if(box[i][y] == player) {
					last_Judge = true;
					break;
				}
			}
			if(count >= 1 && last_Judge) {
				judge = 1;
			}
			while(count >= 1&&last_Judge) {
				box[x-count][y] = player;
				count --;
			}
		}
		
		if(box[x+1][y] != 0&&x<=6 && box[x+1][y] != 3) { //나두는 곳 (아래) 판단
			last_Judge = false;count = 0;
			for(int i = x+1; i <= 8; i++) {
				if(box[i][y] == 0 || box[i][y] == 3) {
					count = 0;
					break;
				}else if(box[i][y] != player) {
					count ++; 
				}else if(box[i][y] == player) {
					last_Judge = true;
					break;
				}
			}
			if(count >= 1 && last_Judge) {
				judge = 1;
			}
			while(count >= 1 && last_Judge) {
				box[x+count][y] = player;
				count --;
			}
		}
		if(box[x][y-1] != 0&&y>=3 && box[x][y-1] != 3) { //나두는 곳 (왼쪽) 판단
			last_Judge = false;count = 0;
			for(int i = y-1; i >= 1; i--) {
				if(box[x][i] == 0 || box[x][i] == 3) {
					count = 0;
					break;
				}else if(box[x][i] != player) {
					count ++; 
				}else if(box[x][i] == player) {
					last_Judge = true;
					break;
				}}
			if(count >= 1 && last_Judge) {
				judge = 1;
			}
			while(count >= 1 && last_Judge) {
				box[x][y-count] = player;
				count --;
			}
		}
		if(box[x][y+1] != 0 && y <= 6 && box[x][y+1] != 3) { //나두는 곳 (오른쪽) 판단
			last_Judge = false;count = 0;
			for(int i = y+1; i <= 8; i++) {
				if(box[x][i] == 0 || box[x][i] == 3) {
					count = 0;
					break;
				}else if(box[x][i] != player) {
					count ++; 
				}else if(box[x][i] == player) {
					last_Judge = true;
					break;
				}}
			if(count >= 1 && last_Judge) {
				judge = 1;
			}
			while(count >= 1 && last_Judge) {
	 			box[x][y+count] = player;
				count --;
			}
		}
		if(box[x-1][y-1] != 0 && x >= 3 && y >= 3&&box[x-1][y-1] != 3) { //나두는 곳 (왼,위) 판단
			last_Judge = false;count = 0;
			for(int i = 1; x-i >= 1 && y-i >= 1; i++) {
				if(box[x-i][y-i] == 0||box[x-1][y-1] == 3) {
					count = 0;
					break;
				}else if(box[x-i][y-i] != player) {
					count ++; 
				}else if(box[x-i][y-i] == player) {
					last_Judge = true;
					break;
				}}
			if(count >= 1 && last_Judge) {
				judge = 1;
			}
			while(count >= 1 && last_Judge) {
				box[x-count][y-count] = player;
				count --;
			}
		}
		if(box[x+1][y+1] != 0 && x <= 6 && y <= 6&&box[x+1][y+1] != 3) { //나두는 곳 (오른,아래) 판단
			last_Judge = false;count = 0;
			for(int i = 1; x+i <= 8 && y+i <= 8; i++) {
				if(box[x+i][y+i] == 0||box[x+1][y+1] == 3) {
					count = 0;
					break;
				}else if(box[x+i][y+i] != player) {
					count ++; 
				}else if(box[x+i][y+i] == player) {
					last_Judge = true;
					break;
				}}
			if(count >= 1 && last_Judge) {
				judge = 1;
			}
			while(count >= 1 && last_Judge) {
				box[x+count][y+count] = player;
				count --;
			}
		}
		if(box[x-1][y+1] != 0 && x >= 3 && y <= 6 && box[x-1][y+1] != 3) { //나두는 곳 (오른, 위) 판단
			last_Judge = false;count = 0;
			for(int i = 1; x-i >= 1 && y+i <= 8; i++) {
				if(box[x-i][y+i] == 0 || box[x-1][y+1] == 3) {
					count = 0;
					break;
				}else if(box[x-i][y+i] != player) {
					count ++; 
				}else if(box[x-i][y+i] == player) {
					last_Judge = true;
					break;
				}}
			if(count >= 1 && last_Judge) {
				judge = 1;
			}
			while(count >= 1 && last_Judge) {
				box[x-count][y+count] = player;
				count --;
			}
		}
		if(box[x+1][y-1] != 0 && x <= 6 && y >= 3&&box[x+1][y-1] != 3) { //나두는 곳 (왼, 아래) 판단
			last_Judge = false;count = 0;
			for(int i = 1; x+i <= 8 && y-i >= 1; i++) {
				if(box[x+i][y-i] == 0 || box[x+1][y-1] == 3) {
					count = 0;
					break;
				}else if(box[x+i][y-i] != player) {
					count ++; 
				}else if(box[x+i][y-i] == player) {
					last_Judge = true;
					break;
				}}
			if(count >= 1 && last_Judge) {
				judge = 1;
			}
			while(count >= 1 && last_Judge) {
				box[x+count][y-count] = player;
				count --;
			}
		}
//------------------------------------------------------------------------	
		if(judge == 1) {//player교체, 젓지
			
			clickmusic.start();
			box[x][y] = player;
			judge = 0;
			if(player == 1) {
				player = 2;
			}else if(player == 2) {
				player = 1;
			}
		}else {
			cantmusic.start();
			System.out.println("나둘 수 없는 곳");
		}		
		for(int i = 1; i <= 8; i++) {
			for(int j = 1; j <= 8; j++) {
				if(box[i][j] == 3) {
					box[i][j] = 0;
				}
			}
		}
		for(int i = 1; i<= 8; i++) { // game.box 출력
			for(int j = 1; j <= 8; j++) {
				System.out.print(box[i][j]+" ");
			}
			System.out.println("");
		}System.out.println("");

		sa.shadow_countdown(box, player);
		for(int i = 1; i<= 8; i++) { // shadow 출력 
			for(int j = 1; j <= 8; j++) {
				if(box[i][j] == 1) {
					w_coin ++;
				}else if(box[i][j] == 2) {
					b_coin ++;
				}else if(sa.shadowBox[i][j] == 3){
					shadow_count ++;
				}
				System.out.print(sa.shadowBox[i][j]+" ");
			}
			System.out.println("");
		}
		w_box = w_coin;
		b_box = b_coin;
		System.out.println("");
		if(shadow_count == 0) { // 나둘 곳이 없는 경우 
			turnPass = true;
			System.out.println("나둘 수 있는 곳이 없으므로 다시 한번 더");
			if(player == 1) {
				player = 2;
			}else if(player == 2) {
				player = 1;
			}
			sa.shadow_countdown(box, player);
		}
		for(int i = 1; i <= 8; i ++) {
			for(int j = 1; j <= 8; j++) {
				if(sa.shadowBox[i][j] == 3) {
					shadow_count ++;
				}
			}
		}
		if(player == 1) {
			System.out.println("흰팀 차례입니다.");
		}else {
			System.out.println("검은팀 차례입니다.");
		}
	
		System.out.printf("흰팀 : %d   흑팀: %d\n",w_coin,b_coin); 
		if(w_coin + b_coin == 64||w_coin == 0||b_coin == 0||shadow_count == 0) { //승부 결과
			System.out.println("게임이 끝났습니다.");
			winJudge = true;
			if(w_coin > b_coin) {
				System.out.print("흰 팀이 이겼습니다.");
			}else if(w_coin < b_coin) {
				System.out.print("검은팀이 이겼습니다.");
			}else {
				System.out.print("비겼습니다.");
			}
		}
	}
}
