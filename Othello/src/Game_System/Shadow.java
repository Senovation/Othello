package Game_System;

public class Shadow {
	int shadowBox[][];
	int player;
	
	public void shadow_countdown(int[][] box, int player) {
		boolean judge = false;
		
		this.shadowBox = box;
		this.player = player;
		
		for(int i = 1; i <= 8; i++) {
			for(int j = 1; j <= 8; j++){
				if(shadowBox[i][j] == 1 && player == 1|| shadowBox[i][j] == 2&& player == 2) {
					judge = false;
					for(int z = j+1; z <= 8; z++) {
						if(shadowBox[i][z] != 0 && shadowBox[i][z] != 3) {
							if(shadowBox[i][z] == player) {
								break;
							}else if(shadowBox[i][z] ==1 && player == 2|| shadowBox[i][z] == 2 && player ==1) {
								judge = true;
								continue;
							}
						}else if(judge == true && shadowBox[i][z] != 3) {
							shadowBox[i][z] = 3;
							break;
						}else {
							break;
						}
					}
					judge = false;
					for(int z = j-1; z >= 1; z--) {
						if(shadowBox[i][z] != 0 && shadowBox[i][z] != 3) {
							if(shadowBox[i][z] == player) {
								break;
							}else if(shadowBox[i][z] ==1 && player == 2|| shadowBox[i][z] == 2 && player ==1) {
								judge = true;
								continue;
							}
						}else if(judge == true && shadowBox[i][z] != 3) {
							shadowBox[i][z] = 3;
							break;
						}else {
							break;
						}
					}
					judge = false;
					for(int z = i+1; z <= 8; z++) {
						if(shadowBox[z][j] != 0 && shadowBox[z][j] != 3) {
							if(shadowBox[z][j] == player) {
								break;
							}else if(shadowBox[z][j] ==1 && player == 2|| shadowBox[z][j] == 2 && player ==1) {
								judge = true;
								continue;
							}
						}else if(judge == true && shadowBox[z][j] != 3) {
							shadowBox[z][j] = 3;
							break;
						}else {
							break;
						}
					}
					judge = false;
					for(int z = i-1; z >= 1; z--) {
						if(shadowBox[z][j] != 0 && shadowBox[z][j] != 3) {
							if(shadowBox[z][j] == player) {
								break;
							}else if(shadowBox[z][j] ==1 && player == 2|| shadowBox[z][j] == 2 && player ==1) {
								judge = true;
								continue;
							}
						}else if(judge == true && shadowBox[z][j] != 3) {
							shadowBox[z][j] = 3;
							break;
						}else {
							break;
						}
					}
					judge = false;
					for(int z = 1; i + z <= 8 && j + z<= 8; z++) {
						if(shadowBox[i+z][j+z] != 0 && shadowBox[i+z][j+z] != 3) {
							if(shadowBox[i+z][j+z] == player) {
								break;
							}else if(shadowBox[i+z][j+z] ==1 && player == 2|| shadowBox[i+z][j+z] == 2 && player ==1) {
								judge = true;
								continue;
							}
						}else if(judge == true && shadowBox[i+z][j+z] != 3) {
							shadowBox[i+z][j+z] = 3;
							break;
						}else {
							break;
						}
					}
					judge = false;
					for(int z = 1; i - z >= 1 && j - z >= 1; z++) {
						if(shadowBox[i-z][j-z] != 0 && shadowBox[i-z][j-z] != 3) {
							if(shadowBox[i-z][j-z] == player) {
								break;
							}else if(shadowBox[i-z][j-z] ==1 && player == 2|| shadowBox[i-z][j-z] == 2 && player ==1) {
								judge = true;
								continue;
							}
						}else if(judge == true && shadowBox[i-z][j-z] != 3) {
							shadowBox[i-z][j-z] = 3;
							break;
						}else {
							break;
						}
					}
					judge = false;
					for(int z = 1; i + z <= 8 && j  - z >= 1; z++) {
						if(shadowBox[i+z][j-z] != 0 && shadowBox[i+z][j-z] != 3) {
							if(shadowBox[i+z][j-z] == player) {
								break;
							}else if(shadowBox[i+z][j-z] ==1 && player == 2|| shadowBox[i+z][j-z] == 2 && player ==1) {
								judge = true;
								continue;
							}
						}else if(judge == true && shadowBox[i+z][j-z] != 3) {
							shadowBox[i+z][j-z] = 3;
							break;
						}else {
							break;
						}
					}
					judge = false;
					for(int z = 1; i -z >= 1 && j + z <= 8; z++) {
						if(shadowBox[i-z][j+z] != 0 && shadowBox[i-z][j+z] != 3) {
							if(shadowBox[i-z][j+z] == player) {
								break;
							}else if(shadowBox[i-z][j+z] ==1 && player == 2|| shadowBox[i-z][j+z] == 2 && player ==1) {
								judge = true;
								continue;
							}
						}else if(judge == true && shadowBox[i-z][j+z] != 3) {
							shadowBox[i-z][j+z] = 3;
							break;
						}else {
							break;
						}
					}
				}
			}
		}
	}
}
