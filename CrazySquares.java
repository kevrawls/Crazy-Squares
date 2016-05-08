

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.text.DecimalFormat;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;


//x = sqrt((r^2)-((y-b)^2)) - a
//y = sqrt((r^2)-((x-a)^2)) - b
//where (x,y) is a point on a circle, (a,b) is the center and r is the radius
 
public class CrazySquares extends JFrame implements Runnable{
   ClassLoader cl = this.getClass().getClassLoader();
	private boolean play = true;
	//BLUE
	private boolean isPressingRight;
	private boolean isPressingLeft;
	private boolean isPressingUp;
	private boolean isPressingDown;
	//RED
	private boolean isPressingD;
	private boolean isPressingA;
	private boolean isPressingW;
	private boolean isPressingS;
	//YELLOW
	private boolean isPressingJ;
	private boolean isPressingL;
	private boolean isPressingI;
	private boolean isPressingK;
	//GREEN
	private boolean isPressing5;
	private boolean isPressing6;
	private boolean isPressingF6;
	private boolean isPressing7;
	
	private boolean kickBall;
	private boolean ballMovingRight;
	private boolean ballMovingLeft;
	private boolean ballMovingDown;
	private boolean ballMovingUp;
	private boolean createdBall;
	private boolean bounceBack;
	private boolean blueScoring;
	private boolean redScoring;
	private boolean yellowScoring;
	private boolean greenScoring;
	private boolean gameOver;
	private boolean blueWin;
	private boolean redWin;
	private boolean yellowWin;
	private boolean greenWin;
	private boolean hasSetBall;
	private boolean blueFaster;
	private boolean redFaster;
	private boolean yellowFaster;
	private boolean greenFaster;
	private boolean blueBigger;
	private boolean redBigger;
	private boolean yellowBigger;
	private boolean greenBigger;
	private boolean twoPlayerGame;
	private boolean hasGameStarted;
	private boolean twoPlayerHover;
	private boolean twoPlayerSDHover;
	private boolean threePlayerHover;
	private boolean threePlayerSDHover;
	private boolean fourPlayerHover;
	private boolean fourPlayerSDHover;
	private boolean controlsHover;
	private boolean suddenDeath;
	private boolean suddenDeathAlert;
	private boolean suddenDeathWait;
	private boolean threePlayerGame;
	private boolean fourPlayerGame;
	private boolean setSquaresThree;
	private boolean setSquaresFour;
	private boolean redOnFire;
	private boolean blueOnFire;
	private boolean yellowOnFire;
	private boolean greenOnFire;
	private boolean blueKickedRight;
	private boolean blueKickedLeft;
	private boolean blueKickedUp;
	private boolean blueKickedDown;
	private boolean redKickedRight;
	private boolean redKickedLeft;
	private boolean redKickedUp;
	private boolean redKickedDown;
	private boolean yellowKickedRight;
	private boolean yellowKickedLeft;
	private boolean yellowKickedUp;
	private boolean yellowKickedDown;
	private boolean greenKickedRight;
	private boolean greenKickedLeft;
	private boolean greenKickedUp;
	private boolean greenKickedDown;
	private boolean suddenDeathAdjust;
	
	private boolean bluePushedRight;
	private boolean redPushedRight;
	private boolean yellowPushedRight;
	private boolean greenPushedRight;
	private boolean bluePushedLeft;
	private boolean redPushedLeft;
	private boolean yellowPushedLeft;
	private boolean greenPushedLeft;
	private boolean bluePushedUp;
	private boolean redPushedUp;
	private boolean yellowPushedUp;
	private boolean greenPushedUp;
	private boolean bluePushedDown;
	private boolean redPushedDown;
	private boolean yellowPushedDown;
	private boolean greenPushedDown;
	private boolean paused;
	private boolean isPressingESC;
	private boolean showControls;
   private ImageIcon image = new ImageIcon("uwlogo.png");
	
	private int blueX = 1000;
	private int blueY = 300;
	private int redX = 50;
	private int redY = 300;
	private int yellowX = 525;
	private int yellowY = 500;
	private int greenX = 425;
	private int greenY = 400;
	private int ballX = 291;
	private int ballY = 200;
	private int ballDiam = 30;
	private int blueDim = 50;
	private int redDim = 50;
	private int yellowDim = 50;
	private int greenDim = 50;
	private int kickBallCount;
	private int blueMoveCount;
	private int redMoveCount;
	private int yellowMoveCount;
	private int greenMoveCount;
	private int ballMoveCount;
	private int ballMovingRightCount;
	private int ballMovingRightTempCount;
	private int ballMovingLeftCount;
	private int ballMovingLeftTempCount;
	private int ballMovingDownCount;
	private int ballMovingDownTempCount;
	private int ballMovingUpCount;
	private int ballMovingUpTempCount;
	private int blueTime;
	private int redTime;
	private int yellowTime;
	private int greenTime;
	private int blueScore;
	private int redScore;
	private int yellowScore;
	private int greenScore;
	private int blueScoreCount;
	private int redScoreCount;
	private int yellowScoreCount;
	private int greenScoreCount;
	private int levelSeconds = 0;
	private int levelMinutes = 2;
	private int secondCounter;
	private int powerupCount;
	private int blueSpeed = 2;
	private int redSpeed = 2;
	private int yellowSpeed = 2;
	private int greenSpeed = 2;
	private int blueFasterCount;
	private int redFasterCount;
	private int yellowFasterCount;
	private int greenFasterCount;
	private int blueBiggerCount;
	private int redBiggerCount;
	private int yellowBiggerCount;
	private int greenBiggerCount;
	private int suddenDeathCount;
	//All for the on fire powerup, yeah I know it sucks, but you know what? Life sucks! Get over it!
	private int blueOnFireCount;
	private int redOnFireCount;
	private int yellowOnFireCount;
	private int greenOnFireCount;
	private int blueKickedRightCount;
	private int blueKickedLeftCount;
	private int blueKickedUpCount;
	private int blueKickedDownCount;
	private int redKickedRightCount;
	private int redKickedLeftCount;
	private int redKickedUpCount;
	private int redKickedDownCount;
	private int yellowKickedRightCount;
	private int yellowKickedLeftCount;
	private int yellowKickedUpCount;
	private int yellowKickedDownCount;
	private int greenKickedRightCount;
	private int greenKickedLeftCount;
	private int greenKickedUpCount;
	private int greenKickedDownCount;
	
	private int redPushCount;
	private int bluePushCount;
	private int yellowPushCount;
	private int greenPushCount;
	
	private int counter;
	
	
	private Rectangle twoPlayerStartButton = new Rectangle(450, 330, 200, 40);
	private Rectangle twoPlayerSDButton = new Rectangle(680, 330, 50, 40);
	private Rectangle threePlayerStartButton = new Rectangle(450, 400, 200, 40);
	private Rectangle threePlayerSDButton = new Rectangle(680, 400, 50, 40);
	private Rectangle fourPlayerStartButton = new Rectangle(450, 470, 200, 40);
	private Rectangle fourPlayerSDButton = new Rectangle(680, 470, 50, 40);
	private Rectangle controlsButton = new Rectangle(500, 540, 180, 40);
	
	private ArrayList<Rectangle> rectSet;
	private ArrayList<Powerup> powerupSet;
	
	private Image dbImage;
	private Image character;
	private Graphics dbg;
	
	public void run() {
		while(play){
		try {
			if(!gameOver && hasGameStarted && !paused){
				secondCounter++;
				if(secondCounter == 1000){
					secondCounter = 0;
					if(!suddenDeath && !suddenDeathWait){
						levelSeconds--;
					}
					if(levelMinutes == 0 && levelSeconds == 0){
						gameOver = true;
						if(twoPlayerGame){
							if(redScore > blueScore){
								blueWin = true;
							} else if(redScore < blueScore){
								redWin = true;
							} else {
								suddenDeathAlert = true;
								suddenDeath = true;
								suddenDeathAdjust();
								resetLevel();
							}
						} else if(threePlayerGame){
							if(redScore > blueScore && redScore > yellowScore){
								redWin = true;
							} else if(blueScore > redScore && blueScore > yellowScore){
								blueWin = true;
							} else if(yellowScore > redScore && yellowScore > blueScore){
								yellowWin = true;
							}else {
								suddenDeathAlert = true;
								suddenDeath = true;
								suddenDeathAdjust();
								resetLevel();
							}
						} else if(fourPlayerGame){
							if(redScore > blueScore && redScore > yellowScore && redScore > greenScore){
								redWin = true;
							} else if(blueScore > redScore && blueScore > yellowScore && blueScore > greenScore){
								blueWin = true;
							} else if(yellowScore > redScore && yellowScore > blueScore && yellowScore > greenScore){
								yellowWin = true;
							}  else if(greenScore > redScore && greenScore > blueScore && greenScore > yellowScore){
								greenWin = true;
							} else {
								suddenDeathAlert = true;
								suddenDeath = true;
								suddenDeathAdjust();
								resetLevel();
							}
						}
					}
					
					if(levelSeconds < 0){
						levelSeconds = 59;
						
						levelMinutes--;
					}
				}
				
				if(suddenDeath){
					if(twoPlayerGame){
						if(redScore > blueScore){
							blueWin = true;
							gameOver = true;
						} else if(redScore < blueScore){
							redWin = true;
							gameOver = true;
						}
					} else if(threePlayerGame){
						if(redScore > blueScore && redScore > yellowScore){
							redWin = true;
							gameOver = true;
						} else if(blueScore > redScore && blueScore > yellowScore){
							blueWin = true;
							gameOver = true;
						} else if(yellowScore > redScore && yellowScore > blueScore){
							yellowWin = true;
							gameOver = true;
						}	
					} else if(fourPlayerGame){
						if(redScore > blueScore && redScore > yellowScore && redScore > greenScore){
							redWin = true;
							gameOver = true;
						} else if(blueScore > redScore && blueScore > yellowScore && blueScore > greenScore){
							blueWin = true;
							gameOver = true;
						} else if(yellowScore > redScore && yellowScore > blueScore && yellowScore > greenScore){
							yellowWin = true;
							gameOver = true;
						}  else if(greenScore > redScore && greenScore > blueScore && greenScore > yellowScore){
							greenWin = true;
							gameOver = true;
						} 
					}
				}
			}
			if(!gameOver && hasGameStarted && !paused){
			scoreHandler();
			if(twoPlayerGame){
				if(ballX + 30 >= 600){
					blueTime += 1;
					if(blueScoring){
						blueScoreCount++;
						if(blueScoreCount == 1000){
							blueScore++;
							blueScoreCount = 0;
						}
					}
				} else {
					blueTime = 0;
					blueScoreCount = 0;
				}
				if(ballX <= 500){
					redTime += 1;
					if(redScoring){
						redScoreCount++;
						if(redScoreCount == 1000){
							redScore++;
							redScoreCount = 0;
						}
					}
				} else {
					redTime = 0;
					redScoreCount = 0;
				}
			} else if(threePlayerGame){
				//BLUE
				Rectangle blue1 = new Rectangle(550, -100, 600, 400);
				Rectangle blue2 = new Rectangle(650, -100, 600, 540);
				//RED
				Rectangle red1 = new Rectangle(-100, -100, 650, 400);
				Rectangle red2 = new Rectangle(-100, -100, 550, 540);
				//YELLOW
				Rectangle yellow1 = new Rectangle(-100, 440, 1300, 400);
				Rectangle yellow2 = new Rectangle(450, 360, 200, 80);
				
				Rectangle ball = new Rectangle(ballX, ballY, 30, 30);
				if(ball.intersects(blue1) || ball.intersects(blue2)){
					blueTime += 1;
					if(blueScoring){
						blueScoreCount++;
						if(blueScoreCount == 1000){
							blueScore++;
							blueScoreCount = 0;
						}
					}
				} else {
					blueTime = 0;
					blueScoreCount = 0;
				}
				if(ball.intersects(red1) || ball.intersects(red2)){
					redTime += 1;
					if(redScoring){
						redScoreCount++;
						if(redScoreCount == 1000){
							redScore++;
							redScoreCount = 0;
						}
					}
				} else {
					redTime = 0;
					redScoreCount = 0;
				}
				if(ball.intersects(yellow1) || ball.intersects(yellow2)){
					yellowTime += 1;
					if(yellowScoring){
						yellowScoreCount++;
						if(yellowScoreCount == 1000){
							yellowScore++;
							yellowScoreCount = 0;
						}
					}
				} else {
					yellowTime = 0;
					yellowScoreCount = 0;
				}
			} else if(fourPlayerGame){
				//BLUE
				Rectangle blue1 = new Rectangle(0, 0, 510, 300);
				//RED
				Rectangle red1 = new Rectangle(590, 0, 500, 300);
				//YELLOW
				Rectangle yellow1 = new Rectangle(0, 370, 510, 300);
				//GREEN
				Rectangle green1 = new Rectangle(590, 370, 500, 290);
				
				Rectangle ball = new Rectangle(ballX, ballY, 30, 30);
				
				if(ball.intersects(blue1)){
					blueTime += 1;
					if(blueScoring){
						blueScoreCount++;
						if(blueScoreCount == 1000){
							blueScore++;
							blueScoreCount = 0;
						}
					}
				} else {
					blueTime = 0;
					blueScoreCount = 0;
				}
				if(ball.intersects(red1)){
					redTime += 1;
					if(redScoring){
						redScoreCount++;
						if(redScoreCount == 1000){
							redScore++;
							redScoreCount = 0;
						}
					}
				} else {
					redTime = 0;
					redScoreCount = 0;
				}
				if(ball.intersects(yellow1)){
					yellowTime += 1;
					if(yellowScoring){
						yellowScoreCount++;
						if(yellowScoreCount == 1000){
							yellowScore++;
							yellowScoreCount = 0;
						}
					}
				} else {
					yellowTime = 0;
					yellowScoreCount = 0;
				}
				if(ball.intersects(green1)){
					greenTime += 1;
					if(greenScoring){
						greenScoreCount++;
						if(greenScoreCount == 1000){
							greenScore++;
							greenScoreCount = 0;
						}
					}
				} else {
					greenTime = 0;
					greenScoreCount = 0;
				}
			}
		}
			
			if(!paused){
				move();
			}
			
				Thread.sleep(1);
			}catch(Exception e){
				System.out.println("Calvin is a Proper Gentelman");
			}	
		}
	}
	public class MouseHandler extends MouseAdapter {
		
		@Override
		public void mouseMoved(MouseEvent e) {
			int mx = e.getX();
			int my = e.getY();
			if(mx > twoPlayerStartButton.x && mx < twoPlayerStartButton.x + twoPlayerStartButton.width
					&& my > twoPlayerStartButton.y && my < twoPlayerStartButton.y + twoPlayerStartButton.height){
				twoPlayerHover = true;
			} else {
				twoPlayerHover = false;
			}
			if(mx > threePlayerStartButton.x && mx < threePlayerStartButton.x + threePlayerStartButton.width
					&& my > threePlayerStartButton.y && my < threePlayerStartButton.y + threePlayerStartButton.height){
				threePlayerHover = true;
			} else {
				threePlayerHover = false;
			}
			if(mx > fourPlayerStartButton.x && mx < fourPlayerStartButton.x + fourPlayerStartButton.width
					&& my > fourPlayerStartButton.y && my < fourPlayerStartButton.y + fourPlayerStartButton.height){
				fourPlayerHover = true;
			} else {
				fourPlayerHover = false;
			}
			if(mx > twoPlayerSDButton.x && mx < twoPlayerSDButton.x + twoPlayerSDButton.width
					&& my > twoPlayerSDButton.y && my < twoPlayerSDButton.y + twoPlayerSDButton.height){
				twoPlayerSDHover = true;
			} else {
				twoPlayerSDHover = false;
			}
			if(mx > threePlayerSDButton.x && mx < threePlayerSDButton.x + threePlayerSDButton.width
					&& my > threePlayerSDButton.y && my < threePlayerSDButton.y + threePlayerSDButton.height){
				threePlayerSDHover = true;
			} else {
				threePlayerSDHover = false;
			}
			if(mx > fourPlayerSDButton.x && mx < fourPlayerSDButton.x + fourPlayerSDButton.width
					&& my > fourPlayerSDButton.y && my < fourPlayerSDButton.y + fourPlayerSDButton.height){
				fourPlayerSDHover = true;
			} else {
				fourPlayerSDHover = false;
			}
			if(mx > controlsButton.x && mx < controlsButton.x + controlsButton.width
					&& my > controlsButton.y && my < controlsButton.y + controlsButton.height){
				controlsHover = true;
			} else {
				controlsHover = false;
			}
		}
		@Override
		public void mousePressed(MouseEvent e){
			int mx = e.getX();
			int my = e.getY();
			if(mx > twoPlayerStartButton.x && mx < twoPlayerStartButton.x + twoPlayerStartButton.width
					&& my > twoPlayerStartButton.y && my < twoPlayerStartButton.y + twoPlayerStartButton.height){
				hasGameStarted = true;
				twoPlayerGame = true;
				threePlayerGame = false;
				fourPlayerGame = false;
				suddenDeath = false;
            resetLevel();
			} 
			if(mx > threePlayerStartButton.x && mx < threePlayerStartButton.x + threePlayerStartButton.width
					&& my > threePlayerStartButton.y && my < threePlayerStartButton.y + threePlayerStartButton.height){
				hasGameStarted = true;
				threePlayerGame = true;
				twoPlayerGame = false;
				fourPlayerGame = false;
				suddenDeath = false;
				resetLevel();
			}  
			if(mx > fourPlayerStartButton.x && mx < fourPlayerStartButton.x + fourPlayerStartButton.width
					&& my > fourPlayerStartButton.y && my < fourPlayerStartButton.y + fourPlayerStartButton.height){
				hasGameStarted = true;
				fourPlayerGame = true;
				twoPlayerGame = false;
				threePlayerGame = false;
				suddenDeath = false;
				resetLevel();
			} 
			if(mx > twoPlayerSDButton.x && mx < twoPlayerSDButton.x + twoPlayerSDButton.width
					&& my > twoPlayerSDButton.y && my < twoPlayerSDButton.y + twoPlayerSDButton.height){
				hasGameStarted = true;
				twoPlayerGame = true;
				threePlayerGame = false;
				fourPlayerGame = false;
				suddenDeath = true;
            
				suddenDeathAdjust();
				//suddenDeathAlert = true;
			}
			if(mx > threePlayerSDButton.x && mx < threePlayerSDButton.x + threePlayerSDButton.width
					&& my > threePlayerSDButton.y && my < threePlayerSDButton.y + threePlayerSDButton.height){
				hasGameStarted = true;
				threePlayerGame = true;
				twoPlayerGame = false;
				fourPlayerGame = false;
				suddenDeath = true;
  				suddenDeathAdjust();
				//suddenDeathAlert = true;
			}
			if(mx > fourPlayerSDButton.x && mx < fourPlayerSDButton.x + fourPlayerSDButton.width
					&& my > fourPlayerSDButton.y && my < fourPlayerSDButton.y + fourPlayerSDButton.height){
				hasGameStarted = true;
				threePlayerGame = false;
				twoPlayerGame = false;
				fourPlayerGame = true;
				suddenDeath = true;
  				suddenDeathAdjust();
				//suddenDeathAlert = true;
			}
			if(mx > controlsButton.x && mx < controlsButton.x + controlsButton.width
					&& my > controlsButton.y && my < controlsButton.y + controlsButton.height){
				showControls = true;
			}
		}
	}
	public void move(){
		if(!gameOver && hasGameStarted && !suddenDeathWait && !suddenDeathAlert){
		blueMoveCount++;
		redMoveCount++;
		yellowMoveCount++;
		greenMoveCount++;
		//BLUE SQUARE
		if(blueMoveCount == blueSpeed){
			blueMoveCount = 0;
			if(isPressingRight){
				blueX += 1;
			}
			if(isPressingLeft){
				blueX -= 1;
			}
			if(isPressingUp){
				blueY -= 1;
			}
			if(isPressingDown){
				blueY += 1;
			}
			if(blueX + blueDim > 1090){
				blueX = 1090 - blueDim;
			}
			if(blueX < 10){
				blueX = 10;
			}
			if(blueY + blueDim > 590){
				blueY = 590 - blueDim;
			}
			if(blueY < 100){
				blueY = 100;
			}
			
			if(isRightTouching(blueX , blueY, blueDim, blueDim)){
				blueX += 1;
				ballMovingLeft = true; 
				ballMovingLeftCount = 0;
				ballMovingLeftTempCount = 0;
			}
			if(isLeftTouching(blueX, blueY, blueDim, blueDim)){
				blueX -= 1;
				ballMovingRight = true;
				ballMovingRightCount = 0;
				ballMovingRightTempCount = 0;
			}
			if(isBottomTouching(blueX + 1, blueY + 1, blueDim, blueDim)){
				blueY += 1;
				ballMovingUp = true;
				ballMovingUpCount = 0;
				ballMovingUpTempCount = 0;
			}
			if(isTopTouching(blueX + 1, blueY - 1, blueDim, blueDim)){
				ballMovingDown = true;
				ballMovingDownCount = 0;
				ballMovingDownTempCount = 0;
				blueY -= 1;
			}
				if(isTopRightTouching(blueX, blueY, blueDim, blueDim) && isPressingLeft && isPressingDown){
					ballMovingDown = true;
					ballMovingDownCount = 0;
					ballMovingDownTempCount = 0;
					ballMovingLeft = true;
					ballMovingLeftCount = 0;
					ballMovingLeftTempCount = 0;
				}
				if(isTopLeftTouching(blueX, blueY, blueDim, blueDim)  && isPressingRight && isPressingDown){
					ballMovingDown = true;
					ballMovingDownCount = 0;
					ballMovingDownTempCount = 0;
					ballMovingRight = true;
					ballMovingRightCount = 0;
					ballMovingRightTempCount = 0;
				}
				if(isBottomLeftTouching(blueX, blueY, blueDim, blueDim)  && isPressingRight && isPressingUp){
					ballMovingUp = true;
					ballMovingUpCount = 0;
					ballMovingUpTempCount = 0;
					ballMovingRight = true;
					ballMovingRightCount = 0;
					ballMovingRightTempCount = 0;
				}
				if(isBottomRightTouching(blueX, blueY, blueDim, blueDim)  && isPressingLeft && isPressingUp){
					ballMovingUp = true;
					ballMovingUpCount = 0;
					ballMovingUpTempCount = 0;
					ballMovingLeft = true;
					ballMovingLeftCount = 0;
					ballMovingLeftTempCount = 0;
				}
			
		}
		//RED SQUARE
		if(redMoveCount == redSpeed){
			redMoveCount = 0;
		if(isPressingD){
			redX += 1;
		}
		if(isPressingA){
			redX -= 1;
		}
		if(isPressingW){
			redY -= 1;
		}
		if(isPressingS){
			redY += 1;
		}
		if(redX > 1090 - redDim){
			redX = 1090 - redDim;
		}
		if(redX < 10){
			redX = 10;
		}
		if(redY > 590 - redDim){
			redY = 590 - redDim;
		}
		if(redY < 100){
			redY = 100;
		}
				if(isRightTouching(redX , redY, redDim, redDim)){
					redX += 1;
					ballMovingLeft = true; 
					ballMovingLeftCount = 0;
					ballMovingLeftTempCount = 0;
				}
				if(isLeftTouching(redX, redY, redDim, redDim)){
					redX -= 1;
					ballMovingRight = true;
					ballMovingRightCount = 0;
					ballMovingRightTempCount = 0;
				}
				if(isBottomTouching(redX + 1, redY + 1, redDim, redDim)){
					redY += 1;	
					ballMovingUp = true;
					ballMovingUpCount = 0;
					ballMovingUpTempCount = 0;
				}
				if(isTopTouching(redX + 1, redY - 1, redDim, redDim)){
					ballMovingDown = true;
					ballMovingDownCount = 0;
					ballMovingDownTempCount = 0;
					redY -= 1;
				}
					if(isTopRightTouching(redX, redY, redDim, redDim) && isPressingLeft && isPressingDown){
						ballMovingDown = true;
						ballMovingDownCount = 0;
						ballMovingDownTempCount = 0;
						ballMovingLeft = true;
						ballMovingLeftCount = 0;
						ballMovingLeftTempCount = 0;
					}
					if(isTopLeftTouching(redX, redY, redDim, redDim)  && isPressingRight && isPressingDown){
						ballMovingDown = true;
						ballMovingDownCount = 0;
						ballMovingDownTempCount = 0;
						ballMovingRight = true;
						ballMovingRightCount = 0;
						ballMovingRightTempCount = 0;
					}
					if(isBottomLeftTouching(redX, redY, redDim, redDim)  && isPressingRight && isPressingUp){
						ballMovingUp = true;
						ballMovingUpCount = 0;
						ballMovingUpTempCount = 0;
						ballMovingRight = true;
						ballMovingRightCount = 0;
						ballMovingRightTempCount = 0;
					}
					if(isBottomRightTouching(redX, redY, redDim, redDim)  && isPressingLeft && isPressingUp){
						ballMovingUp = true;
						ballMovingUpCount = 0;
						ballMovingUpTempCount = 0;
						ballMovingLeft = true;
						ballMovingLeftCount = 0;
						ballMovingLeftTempCount = 0;
					}
				
		}
		// YELLOW SQUARE
		if(threePlayerGame || fourPlayerGame){
			if(yellowMoveCount == yellowSpeed){
				yellowMoveCount = 0;
				if(isPressingL){
					yellowX += 1;
				}
				if(isPressingJ){
					yellowX -= 1;
				}
				if(isPressingI){
					yellowY -= 1;
				}
				if(isPressingK){
					yellowY += 1;
				}
				if(yellowX > 1090 - yellowDim){
					yellowX = 1090 - yellowDim;
				}
				if(yellowX < 10){
					yellowX = 10;
				}
				if(yellowY > 590 - yellowDim){
					yellowY = 590 - yellowDim;
				}
				if(yellowY < 100){
					yellowY = 100;
				}
				if(isRightTouching(yellowX , yellowY, yellowDim, yellowDim)){
					yellowX += 1;
					ballMovingLeft = true; 
					ballMovingLeftCount = 0;
					ballMovingLeftTempCount = 0;
				}
				if(isLeftTouching(yellowX, yellowY, yellowDim, yellowDim)){
					yellowX -= 1;
					ballMovingRight = true;
					ballMovingRightCount = 0;
					ballMovingRightTempCount = 0;
				}
				if(isBottomTouching(yellowX + 1, yellowY + 1, yellowDim, yellowDim)){
					yellowY += 1;	
					ballMovingUp = true;
					ballMovingUpCount = 0;
					ballMovingUpTempCount = 0;
				}
				if(isTopTouching(yellowX + 1, yellowY - 1, yellowDim, yellowDim)){
					ballMovingDown = true;
					ballMovingDownCount = 0;
					ballMovingDownTempCount = 0;
					yellowY -= 1;
				}
				if(isTopRightTouching(yellowX, yellowY, yellowDim, yellowDim) && isPressingLeft && isPressingDown){
					ballMovingDown = true;
					ballMovingDownCount = 0;
					ballMovingDownTempCount = 0;
					ballMovingLeft = true;
					ballMovingLeftCount = 0;
					ballMovingLeftTempCount = 0;
				}
				if(isTopLeftTouching(yellowX, yellowY, yellowDim, yellowDim)  && isPressingRight && isPressingDown){
					ballMovingDown = true;
					ballMovingDownCount = 0;
					ballMovingDownTempCount = 0;
					ballMovingRight = true;
					ballMovingRightCount = 0;
					ballMovingRightTempCount = 0;
				}
				if(isBottomLeftTouching(yellowX, yellowY, yellowDim, yellowDim)  && isPressingRight && isPressingUp){
					ballMovingUp = true;
					ballMovingUpCount = 0;
					ballMovingUpTempCount = 0;
					ballMovingRight = true;
					ballMovingRightCount = 0;
					ballMovingRightTempCount = 0;
				}
				if(isBottomRightTouching(yellowX, yellowY, yellowDim, yellowDim)  && isPressingLeft && isPressingUp){
					ballMovingUp = true;
					ballMovingUpCount = 0;
					ballMovingUpTempCount = 0;
					ballMovingLeft = true;
					ballMovingLeftCount = 0;
					ballMovingLeftTempCount = 0;
				}
			}
		}
		if(fourPlayerGame){
			if(greenMoveCount == greenSpeed){
				greenMoveCount = 0;
				if(isPressing5){
					greenX -= 1;
				}
				if(isPressing6){
					greenY += 1;
				}
				if(isPressing7){
					greenX += 1;
				}
				if(isPressingF6){
					greenY -= 1;
				}
				if(greenX > 1090 - greenDim){
					greenX = 1090 - greenDim;
				}
				if(greenX < 10){
					greenX = 10;
				}
				if(greenY > 590 - greenDim){
					greenY = 590 - greenDim;
				}
				if(greenY < 100){
					greenY = 100;
				}
				if(isRightTouching(greenX , greenY, greenDim, greenDim)){
					greenX += 1;
					ballMovingLeft = true; 
					ballMovingLeftCount = 0;
					ballMovingLeftTempCount = 0;
				}
				if(isLeftTouching(greenX, greenY, greenDim, greenDim)){
					greenX -= 1;
					ballMovingRight = true;
					ballMovingRightCount = 0;
					ballMovingRightTempCount = 0;
				}
				if(isBottomTouching(greenX + 1, greenY + 1, greenDim, greenDim)){
					greenY += 1;	
					ballMovingUp = true;
					ballMovingUpCount = 0;
					ballMovingUpTempCount = 0;
				}
				if(isTopTouching(greenX + 1, greenY - 1, greenDim, greenDim)){
					ballMovingDown = true;
					ballMovingDownCount = 0;
					ballMovingDownTempCount = 0;
					greenY -= 1;
				}
			}
		}	
		ballMoveCount++;
		if(ballMoveCount == 2){
			ballMoveCount = 0;
		if(!ballMovingRight && !ballMovingLeft && !ballMovingUp && !ballMovingDown){
			bounceBack = false;
		}
		if(pinnedBallOnRight(redX, redY, redDim, redDim) || pinnedBallOnLeft(redX, redY, redDim, redDim)
		|| (pinnedBallOnLeft(redX - 1, redY, redDim, redDim) && redSpeed == 1) || (pinnedBallOnRight(redX + 1, redY, redDim, redDim) && (redSpeed == 1 || redBigger))){
			
			if(ballY < 300){
				ballMovingDown = true;
				ballMovingDownCount = 0;
				ballMovingDownTempCount = 0;
			} else {
				ballMovingUp = true;
				ballMovingUpCount = 0;
				ballMovingUpTempCount = 0;
			}
		}
		if(pinnedBallOnTop(redX, redY, redDim, redDim) || pinnedBallOnBottom(redX, redY, redDim, redDim)){
			if(ballX < 600){
				ballMovingRight = true;
				ballMovingRightCount = 0;
				ballMovingRightTempCount = 0;
			} else {
				ballMovingLeft = true;
				ballMovingLeftCount = 0;
				ballMovingLeftTempCount = 0;
			}
		}
		if(pinnedBallOnRight(blueX, blueY, blueDim, blueDim) || pinnedBallOnLeft(blueX, blueY, blueDim, blueDim)
		|| (pinnedBallOnLeft(blueX - 1, blueY, blueDim, blueDim) && blueSpeed == 1) || (pinnedBallOnRight(blueX + 1, blueY, blueDim, blueDim) && (blueSpeed == 1 || blueBigger))){
			if(ballY < 300){
				ballMovingDown = true;
				ballMovingDownCount = 0;
				ballMovingDownTempCount = 0;
			} else {
				ballMovingUp = true;
				ballMovingUpCount = 0;
				ballMovingUpTempCount = 0;
			}
		}
		if(pinnedBallOnTop(blueX, blueY, blueDim, blueDim) || pinnedBallOnBottom(blueX, blueY, blueDim, blueDim)){
			if(ballX < 600){
				ballMovingRight = true;
				ballMovingRightCount = 0;
				ballMovingRightTempCount = 0;
			} else {
				ballMovingLeft = true;
				ballMovingLeftCount = 0;
				ballMovingLeftTempCount = 0;
			}
		}
		if(pinnedBallOnRight(yellowX, yellowY, yellowDim, yellowDim) || pinnedBallOnLeft(yellowX, yellowY, yellowDim, yellowDim)
				|| (pinnedBallOnLeft(yellowX - 1, yellowY, yellowDim, yellowDim) && yellowSpeed == 1) || (pinnedBallOnRight(yellowX + 1, yellowY, yellowDim, yellowDim) && (yellowSpeed == 1 || yellowBigger))){
					
					if(ballY < 300){
						ballMovingDown = true;
						ballMovingDownCount = 0;
						ballMovingDownTempCount = 0;
					} else {
						ballMovingUp = true;
						ballMovingUpCount = 0;
						ballMovingUpTempCount = 0;
					}
				}
				if(pinnedBallOnTop(yellowX, yellowY, yellowDim, yellowDim) || pinnedBallOnBottom(yellowX, yellowY, yellowDim, yellowDim)){
					if(ballX < 600){
						ballMovingRight = true;
						ballMovingRightCount = 0;
						ballMovingRightTempCount = 0;
					} else {
						ballMovingLeft = true;
						ballMovingLeftCount = 0;
						ballMovingLeftTempCount = 0;
					}
				}
				if(pinnedBallOnRight(greenX, greenY, greenDim, greenDim) || pinnedBallOnLeft(greenX, greenY, greenDim, greenDim)
						|| (pinnedBallOnLeft(greenX - 1, greenY, greenDim, greenDim) && greenSpeed == 1) || (pinnedBallOnRight(greenX + 1, greenY, greenDim, greenDim) && (greenSpeed == 1 || greenBigger))){
							
							if(ballY < 300){
								ballMovingDown = true;
								ballMovingDownCount = 0;
								ballMovingDownTempCount = 0;
							} else {
								ballMovingUp = true;
								ballMovingUpCount = 0;
								ballMovingUpTempCount = 0;
							}
						}
						if(pinnedBallOnTop(greenX, greenY, greenDim, greenDim) || pinnedBallOnBottom(greenX, greenY, greenDim, greenDim)){
							if(ballX < 600){
								ballMovingRight = true;
								ballMovingRightCount = 0;
								ballMovingRightTempCount = 0;
							} else {
								ballMovingLeft = true;
								ballMovingLeftCount = 0;
								ballMovingLeftTempCount = 0;
							}
						}
		kickBall();
		kickSquare();
		boundaryHandler();
		}
		
		//BLUE
		Rectangle blue1 = new Rectangle(550, -100, 600, 400);
		Rectangle blue2 = new Rectangle(650, -100, 600, 540);
		Rectangle blue3 = new Rectangle(0, 0, 510, 300);
		//RED
		Rectangle red1 = new Rectangle(-100, -100, 650, 400);
		Rectangle red2 = new Rectangle(-100, -100, 550, 540);
		Rectangle red3 = new Rectangle(590, 0, 500, 300);
		//YELLOW
		Rectangle yellow1 = new Rectangle(-100, 440, 1300, 400);
		Rectangle yellow2 = new Rectangle(450, 360, 200, 80);
		Rectangle yellow3 = new Rectangle(0, 370, 510, 300);
		//GREEN
		Rectangle green1 = new Rectangle(590, 370, 500, 290);
		
		Rectangle red = new Rectangle(redX, redY, redDim, redDim);
		Rectangle blue = new Rectangle(blueX, blueY, blueDim, blueDim);
		Rectangle yellow = new Rectangle(yellowX, yellowY, yellowDim, yellowDim);
		Rectangle green = new Rectangle(greenX, greenY, greenDim, greenDim);
		
		boolean redTouched = false;
		boolean blueTouched = false;
		boolean yellowTouched = false;
		boolean greenTouched = false;
		
		//RED BLUE
		if((redX + redDim == blueX + 1 || redX + redDim == blueX + 2 || redX + redDim == blueX + 3) && redY <= blueY + blueDim && redY + redDim >= blueY){
			redTouched = true;
			blueTouched = false;
			if(isPressingD){
				redX -= 1;
			}
			if(isPressingLeft){
				blueX += 1;
			}
			if(!isLeftTouchingSquare(blueX, blueY, blueDim, blueDim) && !isRightTouchingSquare(redX, redY, redDim, redDim)){
			if(twoPlayerGame){
				if(isPressingLeft && redX + redDim >= 600 && !redBigger){
					redX -= 1;
				}
				if(isPressingD && blueX  <= 500 && !blueBigger){
					blueX += 1;
				}
			} else if(threePlayerGame){
				if(isPressingLeft && (red.intersects(red1) || red.intersects(red2)) && !redBigger){
					redX -= 1;
				}
				if(isPressingD && (blue.intersects(blue1) || blue.intersects(blue2)) && !blueBigger){
					blueX += 1;
				}
			} else if(fourPlayerGame){
				if(isPressingLeft && (red.intersects(red3)) && !redBigger){
					redX -= 1;
				}
				if(isPressingD && (blue.intersects(blue3)) && !blueBigger){
					blueX += 1;
				}
			}
			}
			if(blueOnFire){
				redKickedLeft = true;
				blueX += 1;
			}
			if(redOnFire){
				blueKickedRight = true;
				redX -= 1;
			}
		}
		if((blueX + blueDim == 1090 || blueX + blueDim == 1091 || blueX + blueDim == 1092) && 
		(redX + redDim == blueX || redX + redDim == blueX - 1 || redX + redDim == blueX - 2) &&  isPressingD){
			bluePushedRight = true;
		} else {
			bluePushedRight = false;
		}
		if((redX == 10 || redX == 9 || redX == 8) && 
		(blueX == redX + redDim || blueX == redX + redDim + 1 || blueX == redX + redDim + 2) && isPressingLeft){
			redPushedLeft = true;
		} else {
			redPushedLeft = false;
		}
		//BLUE RED
		if((redX == blueX + blueDim - 1 || redX == blueX + blueDim - 2 || redX == blueX + blueDim - 3) && redY <= blueY + blueDim && redY + redDim >= blueY){
			redTouched = true;
			blueTouched = false;
			if(isPressingA){
				redX += 1;
			}
			if(isPressingRight){
				blueX -= 1;
			}
			if(!isRightTouchingSquare(blueX, blueY, blueDim, blueDim) && !isLeftTouchingSquare(redX, redY, redDim, redDim)){
			if(twoPlayerGame){
				if(isPressingRight && redX + redDim >= 600 && !redBigger){
					redX += 1;
				}
				if(isPressingA && blueX  <= 500 && !blueBigger){
					blueX -= 1;
				}
			} else if(threePlayerGame){
				if(isPressingRight && (red.intersects(red1) || red.intersects(red2)) && !redBigger){
					redX += 1;
				}
				if(isPressingA && (blue.intersects(blue1) || blue.intersects(blue2)) && !blueBigger){
					blueX -= 1;
				}
			} else if(fourPlayerGame){
				if(isPressingRight && (red.intersects(red3)) && !redBigger){
					redX += 1;
				}
				if(isPressingA && (blue.intersects(blue3)) && !blueBigger){
					blueX -= 1;
				}
			}
			}
			if(blueOnFire){
				redKickedRight = true;
				blueX -= 1;
			}
			if(redOnFire){
				blueKickedLeft = true;
				redX += 1;
			}
		}
		if((blueX == 10 || blueX == 9 || blueX == 8) && 
		(redX == blueX + blueDim || redX == blueX + blueDim + 1 || redX == blueX + blueDim + 2) && isPressingA){
			bluePushedLeft = true;
		} else {
			bluePushedLeft = false;
		}
		if((redX + redDim == 1090 || redX + redDim == 1091 || redX + redDim == 1092) && 
		(blueX + blueDim == redX || blueX + blueDim == redX - 1 || blueX + blueDim == redX - 2) && isPressingRight){
			redPushedRight = true;
		} else {
			redPushedRight = false;
		}
		//RED
		//BLUE
		if((redY + redDim - 1 == blueY || redY + redDim - 2 == blueY  || redY + redDim - 3 == blueY ) && redX < blueX + blueDim && redX + redDim > blueX){
			redTouched = true;
			blueTouched = false;
			if(isPressingS){
				redY -= 1;
			}
			if(isPressingUp){
				blueY += 1;
			}
			if(!isTopTouchingSquare(blueX, blueY, blueDim, blueDim) && !isBottomTouchingSquare(redX, redY, redDim, redDim)){
			if(twoPlayerGame){
				if(isPressingUp && redX + redDim >= 600){
					redY -= 1;
				}
				if(isPressingS && blueX  <= 500){
					blueY += 1;
				}
			} else if(threePlayerGame){
				if(isPressingUp && (red.intersects(red1) || red.intersects(red2)) && !redBigger){
					redY -= 1;
				}
				if(isPressingS && (blue.intersects(blue1) || blue.intersects(blue2)) && !blueBigger){
					blueY += 1;
				}
			} else if(fourPlayerGame){
				if(isPressingUp && (red.intersects(red3)) && !redBigger){
					redY -= 1;
				}
				if(isPressingS && (blue.intersects(blue3)) && !blueBigger){
					blueY += 1;
				}
			}
			}
			if(blueOnFire){
				redKickedUp= true;
				blueY += 1;
			}
			if(redOnFire){
				blueKickedDown = true;
				redY -= 1;
			}
		}
		if((blueY + blueDim == 590 || blueY + blueDim == 591 || blueY + blueDim == 592) && 
		(redY + redDim == blueY || redY + redDim == blueY - 1 || redY + redDim == blueY - 2) && isPressingS){
			bluePushedDown = true;
		} else {
			bluePushedDown = false;
		}
		if((redY == 100 || redY == 99 || redY == 98) && 
		(blueY == redY + redDim || blueY == redY + redDim + 1 || blueY == redY + redDim + 2) && isPressingUp){
			redPushedUp = true;
		} else {
			redPushedUp = false;	
		}
		//BLUE
		//RED
		if((redY == blueY + blueDim - 1 || redY  == blueY + blueDim - 2 || redY  == blueY+ blueDim - 3 ) && redX < blueX + blueDim && redX + redDim > blueX){
			redTouched = true;
			blueTouched = false;
			if(isPressingW){
				redY += 1;
			}
			if(isPressingDown){
				blueY -= 1;
			}
			if(!isBottomTouchingSquare(blueX, blueY, blueDim, blueDim) && !isTopTouchingSquare(redX, redY, redDim, redDim)){
			if(twoPlayerGame){
				if(isPressingDown && redX + redDim >= 600){
					redY += 1;
				}
				if(isPressingW && blueX  <= 500){
					blueY -= 1;
				}
			} else if(threePlayerGame){
				if(isPressingDown && (red.intersects(red1) || red.intersects(red2)) && !redBigger){
					redY += 1;
				}
				if(isPressingW && (blue.intersects(blue1) || blue.intersects(blue2)) && !blueBigger){
					blueY -= 1;
				}
			} else if(fourPlayerGame){
				if(isPressingDown && (red.intersects(red3)) && !redBigger){
					redY += 1;
				}
				if(isPressingW && (blue.intersects(blue3)) && !blueBigger){
					blueY -= 1;
				}
			}
			}
			if(blueOnFire){
				redKickedDown= true;
				blueY -= 1;
			}
			if(redOnFire){
				blueKickedUp = true;
				redY += 1;
			}
		}
		if((blueY == 100 ||  blueY == 99 ||  blueY == 98) && 
		(redY == blueY + blueDim || redY == blueY + blueDim + 1 || redY == blueY + blueDim + 2) && isPressingW){
			bluePushedUp = true;
		} else {
			bluePushedUp = false;
		}
		if((redY + redDim == 590 || redY + redDim == 591 || redY + redDim == 592) && 
		(blueY + blueDim == redY || blueY + blueDim == redY - 1 || blueY + blueDim == redY - 2) && isPressingDown){
			redPushedDown = true;
		} else {
			redPushedDown = false;
		}
		//RED YELLOW
		if(threePlayerGame || fourPlayerGame){
		if((redX + redDim == yellowX + 1 || redX + redDim == yellowX + 2 || redX + redDim == yellowX + 3) && redY <= yellowY + yellowDim && redY + redDim >= yellowY){
			redTouched = true;
			yellowTouched = false;
			if(isPressingD){
				redX -= 1;
			}
			if(isPressingJ){
				yellowX += 1;
			}
			if(yellowOnFire){
				redKickedLeft = true;
				yellowX += 1;
			}
			if(redOnFire){
				yellowKickedRight = true;
					redX -= 1;
			}
			if(!isLeftTouchingSquare(yellowX, yellowY, yellowDim, yellowDim) && !isRightTouchingSquare(redX, redY, redDim, redDim)){
			if(threePlayerGame){
				if(isPressingJ && (red.intersects(red1) || red.intersects(red2)) && !redBigger){
					redX -= 1;
				}
				if(isPressingD && (yellow.intersects(yellow1) || yellow.intersects(yellow2)) && !yellowBigger){
					yellowX += 1;
				}
			} else if(fourPlayerGame){
				if(isPressingJ && (red.intersects(red3)) && !redBigger){
					redX -= 1;
				}
				if(isPressingD && (yellow.intersects(yellow3)) && !yellowBigger){
					yellowX += 1;
				}
			}
			}
			if(yellowOnFire){
				redKickedLeft = true;
				yellowX += 1;
			}
			if(redOnFire){
				yellowKickedRight = true;
				redX -= 1;
			}
		}
		if((yellowX + yellowDim == 1090 || yellowX + yellowDim == 1091|| yellowX + yellowDim == 1092) && 
		(redX + redDim == yellowX || redX + redDim == yellowX - 1 || redX + redDim == yellowX - 2) &&  isPressingD){
			yellowPushedRight = true;
		} else {
			yellowPushedRight = false;
		}
		if(!redPushedLeft){
			if((redX == 10 || redX == 9 || redX == 8) && 
			(yellowX == redX + redDim || yellowX == redX + redDim + 1 || yellowX == redX + redDim + 2) && isPressingJ){
				redPushedLeft = true;
			} else {
				redPushedLeft = false;
			}
		}
				//yellow RED
				if((redX == yellowX + yellowDim - 1 || redX == yellowX + yellowDim - 2 || redX == yellowX + yellowDim - 3) && redY <= yellowY + yellowDim && redY + redDim >= yellowY){
					redTouched = true;
					yellowTouched = false;
					if(isPressingA){
						redX += 1;
					}
					if(isPressingL){
						yellowX -= 1;
					}
					if(yellowOnFire){
						redKickedRight = true;
						yellowX -= 1;
					}
					if(redOnFire){
						yellowKickedLeft = true;
						redX += 1;
					}
					if(!isRightTouchingSquare(yellowX, yellowY, yellowDim, yellowDim) && !isLeftTouchingSquare(redX, redY, redDim, redDim)){
						if(threePlayerGame){
							if(isPressingL && (red.intersects(red1) || red.intersects(red2)) && !redBigger){
								redX += 1;
							}
							if(isPressingA && (yellow.intersects(yellow1) || yellow.intersects(yellow2)) && !yellowBigger){
								yellowX -= 1;
							}
						}
						if(fourPlayerGame){
							if(isPressingL && (red.intersects(red3)) && !redBigger){
								redX += 1;
							}
							if(isPressingA && (yellow.intersects(yellow3)) && !yellowBigger){
								yellowX -= 1;
							}
						}
					}
					if(yellowOnFire){
						redKickedRight= true;
						yellowX -= 1;
					}
					if(redOnFire){
						yellowKickedLeft = true;
						redX += 1;
					}
				}
				if((yellowX == 10 || yellowX == 9 || yellowX == 8) && 
				(redX == yellowX + yellowDim || redX == yellowX + yellowDim + 1 || redX == yellowX + yellowDim + 2) && isPressingA){
					yellowPushedLeft = true;
				} else {
					yellowPushedLeft = false;
				}
				if(!redPushedRight){
					if((redX + redDim == 1090 || redX + redDim == 1091 || redX + redDim == 1092) && 
					(yellowX + yellowDim == redX || yellowX + yellowDim == redX - 1 || yellowX + yellowDim == redX - 2) && isPressingL){
						redPushedRight = true;
					} else {
						redPushedRight = false;
					}
				}
				//RED
				//yellow
				if((redY + redDim - 1 == yellowY || redY + redDim - 2 == yellowY  || redY + redDim - 3 == yellowY ) && redX < yellowX + yellowDim && redX + redDim > yellowX){
					redTouched = true;
					yellowTouched = false;
					if(isPressingS){
						redY -= 1;
					}
					if(isPressingI){
						yellowY += 1;
					}
					if(yellowOnFire){
						redKickedUp= true;
						yellowY += 1;
					}
					if(redOnFire){
						yellowKickedDown = true;
						redY -= 1;
					}
					if(!isTopTouchingSquare(yellowX, yellowY, yellowDim, yellowDim) && !isBottomTouchingSquare(redX, redY, redDim, redDim)){
						if(threePlayerGame){
							if(isPressingI && (red.intersects(red1) || red.intersects(red2)) && !redBigger){
								redY -= 1;
							}
							if(isPressingS && (yellow.intersects(yellow1) || yellow.intersects(yellow2)) && !yellowBigger){
								yellowY += 1;
							}
						}
						if(fourPlayerGame){
							if(isPressingI && (red.intersects(red3)) && !redBigger){
								redY -= 1;
							}
							if(isPressingS && (yellow.intersects(yellow3)) && !yellowBigger){
								yellowY += 1;
							}
						}
					}
					if(yellowOnFire){
						redKickedUp = true;
						yellowY += 1;
					}
					if(redOnFire){
						yellowKickedDown = true;
						redY -= 1;
					}
				}
				if((yellowY + yellowDim == 590 || yellowY + yellowDim == 591 || yellowY + yellowDim == 592) && 
				(redY + redDim == yellowY || redY + redDim == yellowY - 1 || redY + redDim == yellowY - 2) && isPressingS){
					yellowPushedDown = true;
				} else {
					yellowPushedDown = false;
				}
				if(!redPushedUp){
					if((redY == 100 || redY == 99 || redY == 98) && 
					(yellowY == redY + redDim || yellowY == redY + redDim + 1 || yellowY == redY + redDim + 2) && isPressingI){
						
						redPushedUp = true;
					} else {
						redPushedUp = false;
						//System.out.println("ad");
					}
				}
				//yellow
				//RED
				if((redY == yellowY + yellowDim - 1 || redY  == yellowY + yellowDim - 2 || redY  == yellowY+ yellowDim - 3 ) && redX < yellowX + yellowDim && redX + redDim > yellowX){
					redTouched = true;
					yellowTouched = false;
					if(isPressingW){
						redY += 1;
					}
					if(isPressingK){
						yellowY -= 1;
					}
					if(yellowOnFire){
						redKickedDown= true;
						yellowY -= 1;
					}
					if(redOnFire){
						yellowKickedUp = true;
						redY += 1;
					}
					if(!isBottomTouchingSquare(yellowX, yellowY, yellowDim, yellowDim) && !isTopTouchingSquare(redX, redY, redDim, redDim)){
						if(threePlayerGame){
							if(isPressingK && (red.intersects(red1) || red.intersects(red2)) && !redBigger){
								redY += 1;
							}
							if(isPressingW && (yellow.intersects(yellow1) || yellow.intersects(yellow2)) && !yellowBigger){
								yellowY -= 1;
							}
						}
						if(fourPlayerGame){
							if(isPressingK && (red.intersects(red3)) && !redBigger){
								redY += 1;
							}
							if(isPressingW && (yellow.intersects(yellow3)) && !yellowBigger){
								yellowY -= 1;
							}
						}
					}
					if(yellowOnFire){
						redKickedDown = true;
						yellowY -= 1;
					}
					if(redOnFire){
						yellowKickedUp = true;
						redY += 1;
					}
				}
				if((yellowY == 100 || yellowY == 99 || yellowY == 98) && 
				(redY == yellowY + yellowDim || redY == yellowY + yellowDim + 1 || redY == yellowY + yellowDim + 2) && isPressingW){
					yellowPushedUp = true;
				} else {
					yellowPushedUp = false;
				}
				if(!redPushedDown){
					if((redY + redDim == 590 || redY + redDim == 591 || redY + redDim == 592) && 
					(yellowY + yellowDim == redY || yellowY + yellowDim == redY - 1 || yellowY + yellowDim == redY - 2) && isPressingK){
						redPushedDown = true;
					} else {
						redPushedDown = false;
					}
				}
				//YELLOW BLUE
				if((yellowX + yellowDim == blueX + 1 || yellowX + yellowDim == blueX + 2 || yellowX + yellowDim == blueX + 3) && yellowY <= blueY + blueDim && yellowY + yellowDim >= blueY){
					blueTouched = true;
					yellowTouched = false;
					if(isPressingL){
						yellowX -= 1;
					}
					if(isPressingLeft){
						blueX += 1;
					}
					if(blueOnFire){
						yellowKickedLeft = true;
						blueX += 1;
					}
					if(yellowOnFire){
						blueKickedRight = true;
						yellowX -= 1;
					}
					if(!isRightTouchingSquare(yellowX, yellowY, yellowDim, yellowDim) && !isLeftTouchingSquare(blueX, blueY, blueDim, blueDim)){
						if(threePlayerGame){
							if(isPressingL && (blue.intersects(blue1) || blue.intersects(blue2)) && !blueBigger){
								blueX += 1;
							}
							if(isPressingLeft && (yellow.intersects(yellow1) || yellow.intersects(yellow2)) && !yellowBigger){
								yellowX -= 1;
							}
						}
						if(fourPlayerGame){
							if(isPressingL && (blue.intersects(blue3)) && !blueBigger){
								blueX += 1;
							}
							if(isPressingLeft && (yellow.intersects(yellow3)) && !yellowBigger){
								yellowX -= 1;
							}
						}
					}
					if(yellowOnFire){
						blueKickedRight = true;
						yellowX -= 1;
					}
					if(blueOnFire){
						yellowKickedLeft = true;
						blueX += 1;
					}
				}
				if(!yellowPushedLeft){
					if((yellowX == 10 || yellowX == 9 || yellowX == 8) && 
					(blueX == yellowX + yellowDim || blueX == yellowX + yellowDim + 1 || blueX == yellowX + yellowDim + 2) && isPressingLeft){
						yellowPushedLeft = true;
					} else {
						yellowPushedLeft = false;
					}
				}
				if(!bluePushedRight){
					if((blueX + blueDim == 1090 || blueX + blueDim == 1091 || blueX + blueDim == 1092) && 
					(yellowX + yellowDim == blueX || yellowX + yellowDim == blueX - 1 || yellowX + yellowDim == blueX - 2) && isPressingL){
						bluePushedRight = true;
					} else {
						bluePushedRight = false;
					}
				}
				//BLUE yellow
				if((yellowX == blueX + blueDim - 1 || yellowX == blueX + blueDim - 2 || yellowX == blueX + blueDim - 3) && yellowY <= blueY + blueDim && yellowY + yellowDim >= blueY){
					blueTouched = true;
					yellowTouched = false;
					if(isPressingJ){
						yellowX += 1;
					}
					if(isPressingRight){
						blueX -= 1;
					}
					if(blueOnFire){
						yellowKickedRight = true;
						blueX -= 1;
					}
					if(yellowOnFire){
						blueKickedLeft = true;
						yellowX += 1;
					}
					if(!isLeftTouchingSquare(yellowX, yellowY, yellowDim, yellowDim) && !isRightTouchingSquare(blueX, blueY, blueDim, blueDim)){
						if(threePlayerGame){
							if(isPressingJ && (blue.intersects(blue1) || blue.intersects(blue2)) && !blueBigger){
								blueX -= 1;
							}
							if(isPressingRight && (yellow.intersects(yellow1) || yellow.intersects(yellow2)) && !yellowBigger){
								yellowX += 1;
							}
						}
						if(fourPlayerGame){
							if(isPressingJ && (blue.intersects(blue3)) && !blueBigger){
								blueX -= 1;
							}
							if(isPressingRight && (yellow.intersects(yellow3)) && !yellowBigger){
								yellowX += 1;
							}
						}
					}
					if(yellowOnFire){
						blueKickedLeft = true;
						yellowX += 1;
					}
					if(blueOnFire){
						yellowKickedRight = true;
						blueX -= 1;
					}
				}
				if(!yellowPushedRight){
					if((yellowX + yellowDim == 1090 || yellowX + yellowDim == 1091 || yellowX + yellowDim == 1092) && 
					(blueX + blueDim == yellowX || blueX + blueDim == yellowX - 1 || blueX + blueDim == yellowX - 2) &&  isPressingRight){
						yellowPushedRight = true;
					} else {
						yellowPushedRight = false;
					}
				}
				if(!bluePushedLeft){
					if((blueX == 10 || blueX == 9 || blueX == 8) && 
					(yellowX == blueX + blueDim || yellowX == blueX + blueDim + 1 || yellowX == blueX + blueDim + 2) && isPressingJ){
						bluePushedLeft = true;
					} else {
						bluePushedLeft = false;
					}
				}
				//yellow
				//BLUE
				if((yellowY + yellowDim - 1 == blueY || yellowY + yellowDim - 2 == blueY  || yellowY + yellowDim - 3 == blueY ) && yellowX < blueX + blueDim && yellowX + yellowDim > blueX){
					blueTouched = true;
					yellowTouched = false;
					if(isPressingK){
						yellowY -= 1;
					}
					if(isPressingUp){
						blueY += 1;
					}
					if(blueOnFire){
						yellowKickedUp= true;
						blueY += 1;
					}
					if(yellowOnFire){
						blueKickedDown = true;
						yellowY -= 1;
					}
					if(!isBottomTouchingSquare(yellowX, yellowY, yellowDim, yellowDim) && !isTopTouchingSquare(blueX, blueY, blueDim, blueDim)){
						if(threePlayerGame){
							if(isPressingK && (blue.intersects(blue1) || blue.intersects(blue2)) && !blueBigger){
								blueY += 1;
							}
							if(isPressingUp && (yellow.intersects(yellow1) || yellow.intersects(yellow2)) && !yellowBigger){
								yellowY -= 1;
							}
						}
						if(fourPlayerGame){
							if(isPressingK && (blue.intersects(blue3)) && !blueBigger){
								blueY += 1;
							}
							if(isPressingUp && (yellow.intersects(yellow3)) && !yellowBigger){
								yellowY -= 1;
							}
						}
					}
					if(yellowOnFire){
						blueKickedDown = true;
						yellowY -= 1;
					}
					if(blueOnFire){
						yellowKickedUp = true;
						blueY += 1;
					}
				}
				if(!yellowPushedUp){
					if((yellowY == 100 ||  yellowY == 99 || yellowY == 98) && 
					(blueY == yellowY + yellowDim || blueY == yellowY + yellowDim + 1 || blueY == yellowY + yellowDim + 2) && isPressingUp){
						yellowPushedUp = true;
					} else {
						yellowPushedUp = false;
					}
				}
				if(!bluePushedDown){
					if((blueY + blueDim == 590 || blueY + blueDim == 591 || blueY + blueDim == 592) && 
					(yellowY + yellowDim == blueY || yellowY + yellowDim == blueY - 1 || yellowY + yellowDim == blueY - 2) && isPressingK){
						bluePushedDown = true;
					} else {
						bluePushedDown = false;
					}
				}
				//BLUE
				//yellow
				if((yellowY == blueY + blueDim - 1 || yellowY  == blueY + blueDim - 2 || yellowY  == blueY+ blueDim - 3 ) && yellowX < blueX + blueDim && yellowX + yellowDim > blueX){
					blueTouched = true;
					yellowTouched = false;
					if(isPressingI){
						yellowY += 1;
					}
					if(isPressingDown){
						blueY -= 1;
					}
					if(blueOnFire){
						yellowKickedDown= true;
						blueY -= 1;
					}
					if(yellowOnFire){
						blueKickedUp = true;
						yellowY += 1;
					}
					if(!isTopTouchingSquare(yellowX, yellowY, yellowDim, yellowDim) && !isBottomTouchingSquare(blueX, blueY, blueDim, blueDim)){
						if(threePlayerGame){
							if(isPressingI && (blue.intersects(blue1) || blue.intersects(blue2)) && !blueBigger){
								blueY -= 1;
							}
							if(isPressingDown && (yellow.intersects(yellow1) || yellow.intersects(yellow2)) && !yellowBigger){
								yellowY += 1;
							}
						} 
						if(fourPlayerGame){
							if(isPressingI && (blue.intersects(blue3)) && !blueBigger){
								blueY -= 1;
							}
							if(isPressingDown && (yellow.intersects(yellow3)) && !yellowBigger){
								yellowY += 1;
							}
						}
					}
					if(yellowOnFire){
						blueKickedUp = true;
						yellowY += 1;
					}
					if(blueOnFire){
						yellowKickedDown = true;
						blueY -= 1;
					}
				}
				if(!yellowPushedDown){
					if((yellowY + yellowDim == 590 || yellowY + yellowDim == 591 || yellowY + yellowDim == 592) && 
					(blueY + blueDim == yellowY || blueY + blueDim == yellowY - 1 || blueY + blueDim == yellowY - 2) && isPressingDown){
						yellowPushedDown = true;
					} else {
						yellowPushedDown = false;
					}
				}
				if(!bluePushedUp){
					if((blueY == 100 || blueY == 99 || blueY == 98) && 
					(yellowY == blueY + blueDim || yellowY == blueY + blueDim + 1 || yellowY == blueY + blueDim + 2) && isPressingI){
						bluePushedUp = true;
					} else {
						bluePushedUp = false;
					}
				}
			}
		//////////////////
		//////////////////
		//////////////////
		if(fourPlayerGame){
			//GREEN BLUE
				if((greenX + greenDim == blueX + 1 || greenX + greenDim == blueX + 2 || greenX + greenDim == blueX + 3) 
					&& greenY <= blueY + blueDim && greenY + greenDim >= blueY){
					redTouched = true;
					blueTouched = false;
					if(isPressing7){
						greenX -= 1;
					}
					if(isPressingLeft){
						blueX += 1;
					}
					if(!isRightTouchingSquare(greenX, greenY, greenDim, greenDim) && !isLeftTouching(blueX, blueY, blueDim, blueDim)){
						if(isPressingLeft && (green.intersects(green1)) && !greenBigger){
							greenX -= 1;
						}
						if(isPressing7 && (blue.intersects(blue3)) && !blueBigger) {
							blueX += 1;
						}
					}
					if(blueOnFire){
						greenKickedLeft = true;
						blueX += 1;
					}
					if(greenOnFire){
						blueKickedRight = true;
						greenX -= 1;
					}
				}
				if((blueX + blueDim == 1090 || blueX + blueDim == 1091 || blueX + blueDim == 1092) && 
				(greenX + greenDim == blueX || greenX + greenDim == blueX - 1 || greenX + greenDim == blueX - 2) &&  isPressing7){
					bluePushedRight = true;
				} else {
					bluePushedRight = false;
				}
				if((greenX == 10 || greenX == 9 || greenX == 8) && 
				(blueX == greenX + greenDim || blueX == greenX + greenDim + 1 || blueX == greenX + greenDim + 2) && isPressingLeft){
					greenPushedLeft = true;
				} else {
					greenPushedLeft = false;
				}
				//BLUE GREEN
				if((greenX == blueX + blueDim - 1 || greenX == blueX + blueDim - 2 || 
				greenX == blueX + blueDim - 3) && greenY <= blueY + blueDim && greenY + greenDim >= blueY){
					greenTouched = true;
					blueTouched = false;
					if(isPressing5){
						greenX += 1;
					}
					if(isPressingRight){
						blueX -= 1;
					}
					if(!isLeftTouchingSquare(greenX, greenY, greenDim, greenDim) && !isRightTouching(blueX, blueY, blueDim, blueDim)){
						if(isPressingRight && (green.intersects(green1)) && !greenBigger){
							greenX += 1;
						}
						if(isPressing5 && (blue.intersects(blue3)) && !blueBigger){
							blueX -= 1;
						}
					}
					if(blueOnFire){
						greenKickedRight = true;
						blueX -= 1;
					}
					if(greenOnFire){
						blueKickedLeft = true;
						greenX += 1;
					}
				}
				if((blueX == 10 || blueX == 9 || blueX == 8) && 
				(greenX == blueX + blueDim || greenX == blueX + blueDim + 1 || greenX == blueX + blueDim + 2) && isPressing5){
					bluePushedLeft = true;
				} else {
					bluePushedLeft = false;
				}
				if((greenX + greenDim == 1090 || greenX + greenDim == 1091 || greenX + greenDim == 1092) && 
				(blueX + blueDim == greenX || blueX + blueDim == greenX - 1 || blueX + blueDim == greenX - 2) && isPressingRight){
					greenPushedRight = true;
				} else {
					greenPushedRight = false;
				}
				//GREEN
				//BLUE
				if((greenY + greenDim - 1 == blueY || greenY + greenDim - 2 == blueY  || greenY + greenDim - 3 == blueY ) && greenX < blueX + blueDim && greenX + greenDim > blueX){
					greenTouched = true;
					blueTouched = false;
					if(isPressing6){
						greenY -= 1;
					}
					if(isPressingUp){
						blueY += 1;
					}
					if(!isBottomTouchingSquare(greenX, greenY, greenDim, greenDim) && !isTopTouching(blueX, blueY, blueDim, blueDim)){
						if(isPressingUp && (green.intersects(green1)) && !greenBigger){
							greenY -= 1;
						}
						if(isPressing6 && (blue.intersects(blue3)) && !blueBigger){
							blueY += 1;
						}
					}
					if(blueOnFire){
						greenKickedUp= true;
						blueY += 1;
					}
					if(greenOnFire){
						blueKickedDown = true;
						greenY -= 1;
					}
				}
				if((blueY + blueDim == 590 || blueY + blueDim == 591 || blueY + blueDim == 592) && 
				(greenY + greenDim == blueY || greenY + greenDim == blueY - 1 || greenY + greenDim == blueY - 2) && isPressing6){
					bluePushedDown = true;
				} else {
					bluePushedDown = false;
				}
				if((greenY == 100 || greenY == 99 || greenY == 98) && 
				(blueY == greenY + greenDim || blueY == greenY + greenDim + 1 || blueY == greenY + greenDim + 2) && isPressingUp){
					greenPushedUp = true;
				} else {
					greenPushedUp = false;	
				}
				//BLUE
				//GREEN
				if((greenY == blueY + blueDim - 1 || greenY  == blueY + blueDim - 2 || greenY  == blueY+ blueDim - 3 ) && greenX < blueX + blueDim && greenX + greenDim > blueX){
					greenTouched = true;
					blueTouched = false;
					if(isPressingF6){
						greenY += 1;
					}
					if(isPressingDown){
						blueY -= 1;
					}
					if(!isTopTouchingSquare(greenX, greenY, greenDim, greenDim) && !isBottomTouching(blueX, blueY, blueDim, blueDim)){
						if(isPressingDown && (green.intersects(green1)) && !greenBigger){
							greenY += 1;
						}
						if(isPressingF6 && (blue.intersects(blue3)) && !blueBigger){
							blueY -= 1;
						}
					}
					if(blueOnFire){
						greenKickedDown= true;
						blueY -= 1;
					}
					if(greenOnFire){
						blueKickedUp = true;
						greenY += 1;
					}
				}
				if((blueY == 100 ||  blueY == 99 ||  blueY == 98) && 
				(greenY == blueY + blueDim || greenY == blueY + blueDim + 1 || greenY == blueY + blueDim + 2) && isPressingF6){
					bluePushedUp = true;
				} else {
					bluePushedUp = false;
				}
				if((greenY + greenDim == 590 || greenY + greenDim == 591 || greenY + greenDim == 592) && 
				(blueY + blueDim == greenY || blueY + blueDim == greenY - 1 || blueY + blueDim == greenY - 2) && isPressingDown){
					greenPushedDown = true;
				} else {
					greenPushedDown = false;
				}
				//RED GREEN
				if((redX + redDim == greenX + 1 || redX + redDim == greenX + 2 || redX + redDim == greenX + 3) && redY <= greenY + greenDim && redY + redDim >= greenY){
					redTouched = true;
					greenTouched = false;
					if(isPressingD){
						redX -= 1;
					}
					if(isPressing5){
						greenX += 1;
					}
					if(!isLeftTouchingSquare(greenX, greenY, greenDim, greenDim) && !isRightTouching(redX, redY, redDim, redDim)){
						if(isPressing5 && (red.intersects(red3)) && !redBigger){
							redX -= 1;
						}
						if(isPressingD && (green.intersects(green1)) && !greenBigger){
							greenX += 1;
						}
					}
					if(greenOnFire){
						redKickedLeft = true;
						greenX += 1;
					}
					if(redOnFire){
						greenKickedRight = true;
							redX -= 1;
					}
					if(greenOnFire){
						redKickedLeft = true;
						greenX += 1;
					}
					if(redOnFire){
						greenKickedRight = true;
						redX -= 1;
					}
				}
				if(!greenPushedRight){
					if((greenX + greenDim == 1090 || greenX + greenDim == 1091|| greenX + greenDim == 1092) && 
					(redX + redDim == greenX || redX + redDim == greenX - 1 || redX + redDim == greenX - 2) &&  isPressingD){
						greenPushedRight = true;
					} else {
						greenPushedRight = false;
					}
				}
				if(!redPushedLeft){
					if((redX == 10 || redX == 9 || redX == 8) && 
					(greenX == redX + redDim || greenX == redX + redDim + 1 || greenX == redX + redDim + 2) && isPressing5){
						redPushedLeft = true;
					} else {
						redPushedLeft = false;
					}
				}
						//GREEN RED
						if((redX == greenX + greenDim - 1 || redX == greenX + greenDim - 2 || redX == greenX + greenDim - 3) && redY <= greenY + greenDim && redY + redDim >= greenY){
							redTouched = true;
							greenTouched = false;
							if(isPressingA){
								redX += 1;
							}
							if(isPressing7){
								greenX -= 1;
							}
							if(greenOnFire){
								redKickedRight = true;
								greenX -= 1;
							}
							if(redOnFire){
								greenKickedLeft = true;
								redX += 1;
							}
							if(!isRightTouchingSquare(greenX, greenY, greenDim, greenDim) && !isLeftTouching(redX, redY, redDim, redDim)){
								if(isPressing7 && (red.intersects(red3)) && !redBigger){
									redX += 1;
								}
								if(isPressingA && (green.intersects(green1)) && !greenBigger){
									greenX -= 1;
								}
							}
							if(greenOnFire){
								redKickedRight= true;
								greenX -= 1;
							}
							if(redOnFire){
								greenKickedLeft = true;
								redX += 1;
							}
						}
						if(!greenPushedLeft){
							if((greenX == 10 || greenX == 9 || greenX == 8) && 
							(redX == greenX + greenDim || redX == greenX + greenDim + 1 || redX == greenX + greenDim + 2) && isPressingA){
								greenPushedLeft = true;
							} else {
								greenPushedLeft = false;
							}
						}
						if(!redPushedRight){
							if((redX + redDim == 1090 || redX + redDim == 1091 || redX + redDim == 1092) && 
							(greenX + greenDim == redX || greenX + greenDim == redX - 1 || greenX + greenDim == redX - 2) && isPressing7){
								redPushedRight = true;
							} else {
								redPushedRight = false;
							}
						}
						//RED
						//GREEN
						if((redY + redDim - 1 == greenY || redY + redDim - 2 == greenY  || redY + redDim - 3 == greenY ) && redX < greenX + greenDim && redX + redDim > greenX){
							redTouched = true;
							greenTouched = false;
							if(isPressingS){
								redY -= 1;
							}
							if(isPressingF6){
								greenY += 1;
							}
							if(greenOnFire){
								redKickedUp= true;
								greenY += 1;
							}
							if(redOnFire){
								greenKickedDown = true;
								redY -= 1;
							}
							if(!isTopTouchingSquare(greenX, greenY, greenDim, greenDim) && !isBottomTouching(redX, redY, redDim, redDim)){
								if(isPressingF6 && (red.intersects(red3)) && !redBigger){
									redY -= 1;
								}
								if(isPressingS && (green.intersects(green1)) && !greenBigger){
									greenY += 1;
								}
							}
							if(greenOnFire){
								redKickedUp = true;
								greenY += 1;
							}
							if(redOnFire){
								greenKickedDown = true;
								redY -= 1;
							}
						}
						if(!greenPushedDown){
							if((greenY + greenDim == 590 || greenY + greenDim == 591 || greenY + greenDim == 592) && 
							(redY + redDim == greenY || redY + redDim == greenY - 1 || redY + redDim == greenY - 2) && isPressingS){
								greenPushedDown = true;
							} else {
								greenPushedDown = false;
							}
						}
						if(!redPushedUp){
							if((redY == 100 || redY == 99 || redY == 98) && 
							(greenY == redY + redDim || greenY == redY + redDim + 1 || greenY == redY + redDim + 2) && isPressingF6){
								
								redPushedUp = true;
							} else {
								redPushedUp = false;
								//System.out.println("ad");
							}
						}
						//GREEN
						//RED
						if((redY == greenY + greenDim - 1 || redY  == greenY + greenDim - 2 || redY  == greenY+ greenDim - 3 ) && redX < greenX + greenDim && redX + redDim > greenX){
							redTouched = true;
							greenTouched = false;
							if(isPressingW){
								redY += 1;
							}
							if(isPressing6){
								greenY -= 1;
							}
							if(greenOnFire){
								redKickedDown= true;
								greenY -= 1;
							}
							if(redOnFire){
								greenKickedUp = true;
								redY += 1;
							}
							if(!isBottomTouchingSquare(greenX, greenY, greenDim, greenDim) && !isTopTouching(redX, redY, redDim, redDim)){
								if(isPressing6 && (red.intersects(red3)) && !redBigger){
									redY += 1;
								}
								if(isPressingW && (green.intersects(green1)) && !greenBigger){
									greenY -= 1;
								}
							}
							if(greenOnFire){
								redKickedDown = true;
								greenY -= 1;
							}
							if(redOnFire){
								greenKickedUp = true;
								redY += 1;
							}
						}
						if(!greenPushedUp){
							if((greenY == 100 || greenY == 99 || greenY == 98) && 
							(redY == greenY + greenDim || redY == greenY + greenDim + 1 || redY == greenY + greenDim + 2) && isPressingW){
								greenPushedUp = true;
							} else {
								greenPushedUp = false;
							}
						}
						if(!redPushedDown){
							if((redY + redDim == 590 || redY + redDim == 591 || redY + redDim == 592) && 
							(greenY + greenDim == redY || greenY + greenDim == redY - 1 || greenY + greenDim == redY - 2) && isPressing6){
								redPushedDown = true;
							} else {
								redPushedDown = false;
							}
						}
						//YELLOW GREEN
						if((yellowX + yellowDim == greenX + 1 || yellowX + yellowDim == greenX + 2 || yellowX + yellowDim == greenX + 3) && yellowY <= greenY + greenDim && yellowY + yellowDim >= greenY){
							greenTouched = true;
							yellowTouched = false;
							if(isPressingL){
								yellowX -= 1;
							}
							if(isPressing5){
								greenX += 1;
							}
							if(greenOnFire){
								yellowKickedLeft = true;
								greenX += 1;
							}
							if(yellowOnFire){
								greenKickedRight = true;
								yellowX -= 1;
							}
							if(!isLeftTouchingSquare(greenX, greenY, greenDim, greenDim) && !isRightTouching(yellowX, yellowY, yellowDim, yellowDim)){
								if(isPressingL && (green.intersects(green1)) && !greenBigger){
									greenX += 1;
								}
								if(isPressing5 && (yellow.intersects(yellow3)) && !yellowBigger){
									yellowX -= 1;
								}
							}
							if(yellowOnFire){
								greenKickedRight = true;
								yellowX -= 1;
							}
							if(greenOnFire){
								yellowKickedLeft = true;
								greenX += 1;
							}
						}
						if(!yellowPushedLeft){
							if((yellowX == 10 || yellowX == 9 || yellowX == 8) && 
							(greenX == yellowX + yellowDim || greenX == yellowX + yellowDim + 1 || greenX == yellowX + yellowDim + 2) && isPressing5){
								yellowPushedLeft = true;
							} else {
								yellowPushedLeft = false;
							}
						}
						if(!greenPushedRight){
							if((greenX + greenDim == 1090 || greenX + greenDim == 1091 || greenX + greenDim == 1092) && 
							(yellowX + yellowDim == greenX || yellowX + yellowDim == greenX - 1 || yellowX + yellowDim == greenX - 2) && isPressingL){
								greenPushedRight = true;
							} else {
								greenPushedRight = false;
							}
						}
						//GREEN yellow
						if((yellowX == greenX + greenDim - 1 || yellowX == greenX + greenDim - 2 || yellowX == greenX + greenDim - 3) && yellowY <= greenY + greenDim && yellowY + yellowDim >= greenY){
							greenTouched = true;
							yellowTouched = false;
							if(isPressingJ){
								yellowX += 1;
							}
							if(isPressing7){
								greenX -= 1;
							}
							if(greenOnFire){
								yellowKickedRight = true;
								greenX -= 1;
							}
							if(yellowOnFire){
								greenKickedLeft = true;
								yellowX += 1;
							}
							if(!isRightTouchingSquare(greenX, greenY, greenDim, greenDim) && !isLeftTouching(yellowX, yellowY, yellowDim, yellowDim)){
								if(isPressingJ && (green.intersects(green1)) && !greenBigger){
									greenX -= 1;
								}
								if(isPressing7 && (yellow.intersects(yellow3)) && !yellowBigger){
									yellowX += 1;
								}
							}
							if(yellowOnFire){
								greenKickedLeft = true;
								yellowX += 1;
							}
							if(greenOnFire){
								yellowKickedRight = true;
								greenX -= 1;
							}
						}
						if(!yellowPushedRight){
							if((yellowX + yellowDim == 1090 || yellowX + yellowDim == 1091 || yellowX + yellowDim == 1092) && 
							(greenX + greenDim == yellowX || greenX + greenDim == yellowX - 1 || greenX + greenDim == yellowX - 2) &&  isPressing7){
								yellowPushedRight = true;
							} else {
								yellowPushedRight = false;
							}
						}
						if(!greenPushedLeft){
							if((greenX == 10 || greenX == 9 || greenX == 8) && 
							(yellowX == greenX + greenDim || yellowX == greenX + greenDim + 1 || yellowX == greenX + greenDim + 2) && isPressingJ){
								greenPushedLeft = true;
							} else {
								greenPushedLeft = false;
							}
						}
						//yellow
						//green
						if((yellowY + yellowDim - 1 == greenY || yellowY + yellowDim - 2 == greenY  || yellowY + yellowDim - 3 == greenY ) && yellowX < greenX + greenDim && yellowX + yellowDim > greenX){
							greenTouched = true;
							yellowTouched = false;
							if(isPressingK){
								yellowY -= 1;
							}
							if(isPressingF6){
								greenY += 1;
							}
							if(greenOnFire){
								yellowKickedUp= true;
								greenY += 1;
							}
							if(yellowOnFire){
								greenKickedDown = true;
								yellowY -= 1;
							}
							if(!isTopTouchingSquare(greenX, greenY, greenDim, greenDim) && !isBottomTouching(yellowX, yellowY, yellowDim, yellowDim)){
								if(isPressingK && (green.intersects(green1)) && !greenBigger){
									greenY += 1;
								}
								if(isPressingF6 && (yellow.intersects(yellow3)) && !yellowBigger){
									yellowY -= 1;
								}
							}
							if(yellowOnFire){
								greenKickedDown = true;
								yellowY -= 1;
							}
							if(greenOnFire){
								yellowKickedUp = true;
								greenY += 1;
							}
						}
						if(!yellowPushedUp){
							if((yellowY == 100 ||  yellowY == 99 || yellowY == 98) && 
							(greenY == yellowY + yellowDim || greenY == yellowY + yellowDim + 1 || greenY == yellowY + yellowDim + 2) && isPressingF6){
								yellowPushedUp = true;
							} else {
								yellowPushedUp = false;
							}
						}
						if(!greenPushedDown){
							if((greenY + greenDim == 590 || greenY + greenDim == 591 || greenY + greenDim == 592) && 
							(yellowY + yellowDim == greenY || yellowY + yellowDim == greenY - 1 || yellowY + yellowDim == greenY - 2) && isPressingK){
								greenPushedDown = true;
							} else {
								greenPushedDown = false;
							}
						}
						//green
						//yellow
						if((yellowY == greenY + greenDim - 1 || yellowY  == greenY + greenDim - 2 || yellowY  == greenY+ greenDim - 3 ) && yellowX < greenX + greenDim && yellowX + yellowDim > greenX){
							greenTouched = true;
							yellowTouched = false;
							if(isPressingI){
								yellowY += 1;
							}
							if(isPressing6){
								greenY -= 1;
							}
							if(greenOnFire){
								yellowKickedDown= true;
								greenY -= 1;
							}
							if(yellowOnFire){
								greenKickedUp = true;
								yellowY += 1;
							}
							if(!isBottomTouchingSquare(greenX, greenY, greenDim, greenDim) && !isTopTouching(yellowX, yellowY, yellowDim, yellowDim)){
								if(isPressingI && (green.intersects(green1)) && !greenBigger){
									greenY -= 1;
								}
								if(isPressing6 && (yellow.intersects(yellow3)) && !yellowBigger){
									yellowY += 1;
								}
							}
							if(yellowOnFire){
								greenKickedUp = true;
								yellowY += 1;
							}
							if(greenOnFire){
								yellowKickedDown = true;
								greenY -= 1;
							}
						}
						if(!yellowPushedDown){
							if((yellowY + yellowDim == 590 || yellowY + yellowDim == 591 || yellowY + yellowDim == 592) && 
							(greenY + greenDim == yellowY || greenY + greenDim == yellowY - 1 || greenY + greenDim == yellowY - 2) && isPressing6){
								yellowPushedDown = true;
							} else {
								yellowPushedDown = false;
							}
						}
						if(!greenPushedUp){
							if((greenY == 100 || greenY == 99 || greenY == 98) && 
							(yellowY == greenY + greenDim || yellowY == greenY + greenDim + 1 || yellowY == greenY + greenDim + 2) && isPressingI){
								greenPushedUp = true;
							} else {
								greenPushedUp = false;
							}
						}
						
			}
		}
	}
	
	//scraped
	public void circleInteractionHandler(){
		//top right
		if(blueY + blueDim < ballY + (ballDiam/2) && blueX > ballX + (ballDiam/2) && blueY + blueDim > ballY){
			if(blueX <= (ballX + ballDiam) - Math.sqrt((Math.pow((ballDiam/2), 2) + Math.pow(blueY + blueDim - (ballY + (ballDiam/2)), 2)) - (ballX + ballDiam)) + 18){
				blueX += 1;
				if(isPressingDown){
					blueY -= 1;
				}
			}
		}
		//bottom right
		if(blueY > ballY + (ballDiam/2) && blueX > ballX + (ballDiam/2) && blueY < ballY + ballDiam){
			if(blueX <= (ballX + ballDiam) - Math.sqrt((Math.pow((ballDiam/2), 2) + Math.pow(blueY - (ballY +(ballDiam/2)), 2)) - (ballX + ballDiam)) + 18){
				blueX += 1;
				if(isPressingUp){
					blueY += 1;
				}
			}		
		}
		//top left
		if(blueY + blueDim < ballY + (ballDiam/2) && blueX + blueDim < ballX + (ballDiam/2) && blueY + blueDim > ballY){
			if(blueX + blueDim >= (ballX) + Math.sqrt((Math.pow((ballDiam/2), 2) + Math.pow(blueY + blueDim - (ballY +(ballDiam/2)), 2)) - (ballX + ballDiam))- 18){
				blueX -= 1;
				if(isPressingDown){
					blueY -= 1;
				}
			}
		}
		//bottom left
		if(blueY > ballY + (ballDiam/2) && blueX + 50 < ballX + (ballDiam/2) && blueY < ballY + ballDiam){
			if(blueX + blueDim >= (ballX) + Math.sqrt((Math.pow((ballDiam/2), 2) + Math.pow(blueY - (ballY +(ballDiam/2)), 2)) - (ballX + ballDiam))- 18){
				blueX -= 1;
				if(isPressingUp){
					blueY += 1;
				}
			}
		}
		//right side 
		if((blueX >= ballX + (ballDiam/2)) && (blueX <= ballX + ballDiam - 1)
		&& blueY + blueDim >= ballY + (ballDiam/2) && blueY <= ballY + (ballDiam/2)){
			blueX += 1;
		}
		//left side
		if((blueX + blueDim == ballX + 1 || blueX + blueDim == ballX + 2 || blueX + blueDim == ballX + 3)
		&& blueY + blueDim >= ballY + (ballDiam/2) && blueY <= ballY + (ballDiam/2)){
			blueX -= 1;
			ballMovingRight = true;
			ballMovingRightCount = 0;
			ballMovingRightTempCount = 0;
		}
		//top side
		if(blueY + blueDim == ballY + 2 && blueX <= ballX + (ballDiam/2) && blueX + blueDim >= ballX + (ballDiam/2)){
			blueY -= 1;
		}
		//bottom side
		if(blueY == ballY + ballDiam - 1 && blueX <= ballX + (ballDiam/2) && blueX + blueDim >= ballX + (ballDiam/2)){
			blueY += 1;
		}
	}
	
	public void createBall(){
		Rectangle rect1 = new Rectangle(300, 200, 12, 30);
		Rectangle rect2 = new Rectangle(291, 209, 30, 12);
		
		Rectangle rect3 = new Rectangle(292, 207, 28, 2);
		Rectangle rect4 = new Rectangle(293, 206, 26, 2);
		Rectangle rect5 = new Rectangle(294, 204, 24, 2);
		Rectangle rect6 = new Rectangle(295, 203, 22, 2);
		Rectangle rect7 = new Rectangle(297, 202, 18, 2);
		Rectangle rect8 = new Rectangle(298, 201, 16, 2);
		
		
		Rectangle rect9 = new Rectangle(292, 221, 28, 2);
		Rectangle rect10 = new Rectangle(293, 222, 26, 2);
		Rectangle rect11 = new Rectangle(294, 224, 24, 2);
		Rectangle rect12 = new Rectangle(295, 225, 22, 2);
		Rectangle rect13 = new Rectangle(297, 226, 18, 2);
		Rectangle rect14 = new Rectangle(298, 227, 16, 2);
		
		rectSet.add(rect1);
		rectSet.add(rect2);
		rectSet.add(rect3);
		rectSet.add(rect4);
		rectSet.add(rect5);
		rectSet.add(rect6);
		rectSet.add(rect7);
		rectSet.add(rect8);
		
		rectSet.add(rect9);
		rectSet.add(rect10);
		rectSet.add(rect11);
		rectSet.add(rect12);
		rectSet.add(rect13);
		rectSet.add(rect14);
	}
	
	public boolean isRightTouchingSquare(int x, int y, int width, int height){
		if((x == blueX + blueDim && y + height > blueY && y < blueY + blueDim) || 
		(x == redX + redDim && y + height > redY && y < redY + redDim) || 
		(x == yellowX + yellowDim && y + height > yellowY && y < yellowY + yellowDim) ||
		(x == greenX + greenDim && y + height > greenY && y < greenY + greenDim)){
			return true;
		}
		return false;
	}
	
	public boolean isLeftTouchingSquare(int x, int y, int width, int height){
		if((x  + width == blueX && y + height > blueY && y < blueY + blueDim) || 
		(x + width == redX && y + height > redY && y < redY + redDim) || 
		(x + width == yellowX && y + height > yellowY && y < yellowY + yellowDim) ||
		(x + width == greenX && y + height > greenY && y < greenY + greenDim)){
			return true;
		}
		return false;
	}
	
	public boolean isTopTouchingSquare(int x, int y, int width, int height){
		if((y + height == blueY && x + width > blueX && x < blueX + blueDim) || 
		(y + height == redY && x + width > redX && x < redX + redDim) || 
		(y + height == yellowY && x + width > yellowX && x < yellowX + yellowDim) ||
		(y + height == greenY && x + width > greenX && x < greenX + greenDim)){
			return true;
		}
		return false;
	}
	
	public boolean isBottomTouchingSquare(int x, int y, int width, int height){
		if((y == blueY + blueDim && x + width > blueX && x < blueX + blueDim) || 
		(y == redY + redDim && x + width > redX && x < redX + redDim) || 
		(y == yellowY + yellowDim && x + width > yellowX && x < yellowX + yellowDim) ||
		(y == greenY + greenDim && x + width > greenX && x < greenX + greenDim)){
			return true;
		}
		return false;
	}
	
	public boolean isRightTouching(int x, int y, int width, int height){
		for(Rectangle rect : rectSet){
			if( x == rect.x + rect.width && y <= rect.y + rect.height && 
			y + height >= rect.y){
				return true;
			}
		}
		return false;
	}
	public boolean isLeftTouching(int x, int y, int width, int height){
		for(Rectangle rect : rectSet){
			if( x + width == rect.x && y <= rect.y + rect.height && 
			y + height >= rect.y){
				return true;
			}
		}
		return false;
	}
	public boolean isBottomTouching(int x, int y, int width, int height){
		for(Rectangle rect : rectSet){
			if((rect.x + rect.width >= x && rect.x <= x + width) &&
			(rect.y + rect.height == y)){
				return true;	
			}
		}	
		return false;
	}
	public boolean isTopTouching(int x, int y, int width, int height){
		for(Rectangle rect : rectSet){
			if((rect.x + rect.width >= x && rect.x <= x + width) &&
			(rect.y == y + height)){
				return true;	
			}
		}	
		return false;
	}
	public boolean isTopRightTouching(int x, int y, int width, int height){
		if(isRightTouching(x, y, width, height) && x > ballX + 15 && y + height < ballY + 15){
			return true;
		}
		return false;
	}
	public boolean isTopLeftTouching(int x, int y, int width, int height){
		if(isLeftTouching(x, y, width, height) && x + width < ballX + 15 && y + height < ballY + 15){
			return true;
		}
		return false;
	}
	public boolean isBottomLeftTouching(int x, int y, int width, int height){
		if(isLeftTouching(x, y, width, height) && x + width < ballX + 15 && y > ballY + 15){
			return true;
		}
		return false;
	}
	public boolean isBottomRightTouching(int x, int y, int width, int height){
		if(isRightTouching(x, y, width, height) && x > ballX + 15 && y > ballY + 15){
			return true;
		}
		return false;
	}
	public boolean pinnedBallOnRight(int x, int y, int width, int height){
		if(isLeftTouching(x, y, width, height) && x + width == 1059){
			return true;
		}
		return false;
	}
	public boolean pinnedBallOnLeft(int x, int y, int width, int height){
		if(isRightTouching(x, y, width, height) && x == 41){
			return true;
		}
		return false;
	}
	public boolean pinnedBallOnTop(int x, int y, int width, int height){
		if(isBottomTouching(x, y, width, height) && y == 130){
			return true;
		}
		return false;
	}
	public boolean pinnedBallOnBottom(int x, int y, int width, int height){
		if(isTopTouching(x, y, width, height) && y + height == 563){
			return true;
		}
		return false;
	}
	
	public void drawBall(Graphics g){
		for(Rectangle rect : rectSet){
			g.fillRect(rect.x, rect.y, rect.width, rect.height);
		}
	}
	
	public void kickBall(){
		if(ballMovingRight){
			ballMovingRightCount++;
			if(ballMovingRightCount < 50){
				for(Rectangle rect : rectSet){
					rect.x += 3;
				}
				ballX += 3;
			} else if(ballMovingRightCount > 50 && ballMovingRightCount < 90){
				for(Rectangle rect : rectSet){
					rect.x += 2;
				}
				ballX += 2;
			} else if(ballMovingRightCount > 90 && ballMovingRightCount < 120){
				for(Rectangle rect : rectSet){
					rect.x += 1;
				}
				ballX += 1;
			}
			if(ballMovingRightCount >= 150){
				
				ballMovingRightCount = 0;
				ballMovingRight = false;
			}
		}
		if(ballMovingLeft){
			ballMovingLeftCount++;
			if(ballMovingLeftCount < 50){
				for(Rectangle rect : rectSet){
					rect.x -= 3;
				}
				ballX -= 3;
			} else if(ballMovingLeftCount > 50 && ballMovingLeftCount < 90){
				for(Rectangle rect : rectSet){
					rect.x -= 2;
				}
				ballX -= 2;
			} else if(ballMovingLeftCount > 90 && ballMovingLeftCount < 120){
				for(Rectangle rect : rectSet){
					rect.x -= 1;
				}
				ballX -= 1;
			
			}
			if(ballMovingLeftCount >= 150){
				ballMovingLeftCount = 0;
				ballMovingLeft = false;
			}
		} if(ballMovingDown){
			ballMovingDownCount++;
			if(ballMovingDownCount < 50){
				for(Rectangle rect : rectSet){
					rect.y += 3;
				}
				ballY += 3;
			} else if(ballMovingDownCount > 50 && ballMovingDownCount < 90){
				for(Rectangle rect : rectSet){
					rect.y += 2;
				}
				ballY += 2;
			} else if(ballMovingDownCount > 90 && ballMovingDownCount < 120){
				for(Rectangle rect : rectSet){
					rect.y += 1;
				}
				ballY += 1;
			} 
			if(ballMovingDownCount >= 150){
				ballMovingDownCount = 0;
				ballMovingDown = false;
			}
		} if(ballMovingUp){
			ballMovingUpCount++;
			if(ballMovingUpCount < 50){
				for(Rectangle rect : rectSet){
					rect.y -= 3;
				}
				ballY -= 3;
			} else if(ballMovingUpCount > 50 && ballMovingUpCount < 90){
				for(Rectangle rect : rectSet){
					rect.y -= 2;
				}
				ballY -= 2;
			} else if(ballMovingUpCount > 90 && ballMovingUpCount < 120){
				for(Rectangle rect : rectSet){
					rect.y -= 1;
				}
				ballY -= 1;
			} 
			if(ballMovingUpCount >= 150){
				ballMovingUpCount = 0;
				ballMovingUp = false;
			}
		}
	}

	public void kickSquare(){
		//BLUE SQUARE
		if(blueKickedRight){
			blueKickedRightCount++;
			if(blueKickedRightCount < 50){
				blueX += 3;
			} else if(blueKickedRightCount > 50 && blueKickedRightCount < 90){
				blueX += 2;
			} else if(blueKickedRightCount > 90 && blueKickedRightCount < 120){
				blueX += 1;
			} 
			if(blueKickedRightCount >= 150){
				
				blueKickedRightCount = 0;
				blueKickedRight = false;
			}
		}
		if(blueKickedLeft){
			blueKickedLeftCount++;
			if(blueKickedLeftCount < 50){
				blueX -= 3;
			} else if(blueKickedLeftCount > 50 && blueKickedLeftCount < 90){
				blueX -= 2;
			} else if(blueKickedLeftCount > 90 && blueKickedLeftCount < 120){
				blueX -= 1;
			} 
			if(blueKickedLeftCount >= 150){
				blueKickedLeftCount = 0;
				blueKickedLeft = false;
			}
		} if(blueKickedDown){
			blueKickedDownCount++;
			if(blueKickedDownCount < 50){
				blueY += 3;
			} else if(blueKickedDownCount > 50 && blueKickedDownCount < 90){
				blueY += 2;
			} else if(blueKickedDownCount > 90 && blueKickedDownCount < 120){
				blueY += 1;
			} 
			if(blueKickedDownCount >= 150){
				blueKickedDownCount = 0;
				blueKickedDown = false;
			}
		} if(blueKickedUp){
			blueKickedUpCount++;
			if(blueKickedUpCount < 50){
				blueY -= 3;
			} else if(blueKickedUpCount > 50 && blueKickedUpCount < 90){
				blueY -= 2;
			} else if(blueKickedUpCount > 90 && blueKickedUpCount < 120){
				blueY -= 1;
			} 
			if(blueKickedUpCount >= 150){
				blueKickedUpCount = 0;
				blueKickedUp = false;
			}
		}
		//RED SQUARE
		if(redKickedRight){
			redKickedRightCount++;
			if(redKickedRightCount < 50){
				redX += 3;
			} else if(redKickedRightCount > 50 && redKickedRightCount < 90){
				redX += 2;
			} else if(redKickedRightCount > 90 && redKickedRightCount < 120){
				redX += 1;
			} 
			if(redKickedRightCount >= 150){
				
				redKickedRightCount = 0;
				redKickedRight = false;
			}
		}
		if(redKickedLeft){
			redKickedLeftCount++;
			if(redKickedLeftCount < 50){
				redX -= 3;
			} else if(redKickedLeftCount > 50 && redKickedLeftCount < 90){
				redX -= 2;
			} else if(redKickedLeftCount > 90 && redKickedLeftCount < 120){
				redX -= 1;
			} 
			if(redKickedLeftCount >= 150){
				redKickedLeftCount = 0;
				redKickedLeft = false;
			}
		} if(redKickedDown){
			redKickedDownCount++;
			if(redKickedDownCount < 50){
				redY += 3;
			} else if(redKickedDownCount > 50 && redKickedDownCount < 90){
				redY += 2;
			} else if(redKickedDownCount > 90 && redKickedDownCount < 120){
				redY += 1;
			} 
			if(redKickedDownCount >= 150){
				redKickedDownCount = 0;
				redKickedDown = false;
			}
		} if(redKickedUp){
			redKickedUpCount++;
			if(redKickedUpCount < 50){
				redY -= 3;
			} else if(redKickedUpCount > 50 && redKickedUpCount < 90){
				redY -= 2;
			} else if(redKickedUpCount > 90 && redKickedUpCount < 120){
				redY -= 1;
			} 
			if(redKickedUpCount >= 150){
				redKickedUpCount = 0;
				redKickedUp = false;
			}
		}
		// YELLOW SQUARE
		if(yellowKickedRight){
			yellowKickedRightCount++;
			if(yellowKickedRightCount < 50){
				yellowX += 3;
			} else if(yellowKickedRightCount > 50 && yellowKickedRightCount < 90){
				yellowX += 2;
			} else if(yellowKickedRightCount > 90 && yellowKickedRightCount < 120){
				yellowX += 1;
			} 
			if(yellowKickedRightCount >= 150){
				
				yellowKickedRightCount = 0;
				yellowKickedRight = false;
			}
		}
		if(yellowKickedLeft){
			yellowKickedLeftCount++;
			if(yellowKickedLeftCount < 50){
				yellowX -= 3;
			} else if(yellowKickedLeftCount > 50 && yellowKickedLeftCount < 90){
				yellowX -= 2;
			} else if(yellowKickedLeftCount > 90 && yellowKickedLeftCount < 120){
				yellowX -= 1;
			} 
			if(yellowKickedLeftCount >= 150){
				yellowKickedLeftCount = 0;
				yellowKickedLeft = false;
			}
		} if(yellowKickedDown){
			yellowKickedDownCount++;
			if(yellowKickedDownCount < 50){
				yellowY += 3;
			} else if(yellowKickedDownCount > 50 && yellowKickedDownCount < 90){
				yellowY += 2;
			} else if(yellowKickedDownCount > 90 && yellowKickedDownCount < 120){
				yellowY += 1;
			} 
			if(yellowKickedDownCount >= 150){
				yellowKickedDownCount = 0;
				yellowKickedDown = false;
			}
		} if(yellowKickedUp){
			yellowKickedUpCount++;
			if(yellowKickedUpCount < 50){
				yellowY -= 3;
			} else if(yellowKickedUpCount > 50 && yellowKickedUpCount < 90){
				yellowY -= 2;
			} else if(yellowKickedUpCount > 90 && yellowKickedUpCount < 120){
				yellowY -= 1;
			} 
			if(yellowKickedUpCount >= 150){
				yellowKickedUpCount = 0;
				yellowKickedUp = false;
			}
		}
		//GREEN SQUARE
		if(greenKickedRight){
			greenKickedRightCount++;
			if(greenKickedRightCount < 50){
				greenX += 3;
			} else if(greenKickedRightCount > 50 && greenKickedRightCount < 90){
				greenX += 2;
			} else if(greenKickedRightCount > 90 && greenKickedRightCount < 120){
				greenX += 1;
			} 
			if(greenKickedRightCount >= 150){
				
				greenKickedRightCount = 0;
				greenKickedRight = false;
			}
		}
		if(greenKickedLeft){
			greenKickedLeftCount++;
			if(greenKickedLeftCount < 50){
				greenX -= 3;
			} else if(greenKickedLeftCount > 50 && greenKickedLeftCount < 90){
				greenX -= 2;
			} else if(greenKickedLeftCount > 90 && greenKickedLeftCount < 120){
				greenX -= 1;
			} 
			if(greenKickedLeftCount >= 150){
				greenKickedLeftCount = 0;
				greenKickedLeft = false;
			}
		} if(greenKickedDown){
			greenKickedDownCount++;
			if(greenKickedDownCount < 50){
				greenY += 3;
			} else if(greenKickedDownCount > 50 && greenKickedDownCount < 90){
				greenY += 2;
			} else if(greenKickedDownCount > 90 && greenKickedDownCount < 120){
				greenY += 1;
			} 
			if(greenKickedDownCount >= 150){
				greenKickedDownCount = 0;
				greenKickedDown = false;
			}
		} if(greenKickedUp){
			greenKickedUpCount++;
			if(greenKickedUpCount < 50){
				greenY -= 3;
			} else if(greenKickedUpCount > 50 && greenKickedUpCount < 90){
				greenY -= 2;
			} else if(greenKickedUpCount > 90 && greenKickedUpCount < 120){
				greenY -= 1;
			} 
			if(greenKickedUpCount >= 150){
				greenKickedUpCount = 0;
				greenKickedUp = false;
			}
		}
	}
	public void boundaryHandler(){
		for(Rectangle rect : rectSet){
			if(rect.x + rect.width >= 1090 && ballMovingRight){
				ballMovingRight = false;
				ballMovingLeft = true;
				ballMovingLeftCount = ballMovingRightCount - 50;
				ballMovingRightCount = 0;
				ballMovingRightTempCount = 0;
				ballMovingLeftTempCount = 0;
				bounceBack = true;
			}
			if(rect.y  <= 100 && ballMovingUp){
				ballMovingUp = false;
				ballMovingDown = true;
				ballMovingDownCount = ballMovingUpCount - 50;
				ballMovingUpCount = 0;
				ballMovingUpTempCount = 0;
				ballMovingDownTempCount = 0;
				bounceBack = true;
			}
			if(rect.x  <= 10 && ballMovingLeft){
				ballMovingLeft = false;
				ballMovingRight = true;
				ballMovingRightCount = ballMovingLeftCount - 50;
				ballMovingLeftCount = 0;
				ballMovingLeftTempCount = 0;
				ballMovingRightTempCount = 0;
				bounceBack = true;
			}
			if(rect.y  >= 590 && ballMovingDown){
				ballMovingDown = false;
				ballMovingUp = true;
				ballMovingUpCount = ballMovingDownCount - 50;
				ballMovingDownCount = 0;
				ballMovingDownTempCount = 0;
				ballMovingUpTempCount = 0;
				bounceBack = true;
			}
		}
	}
	
	public CrazySquares(){
		super();
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setVisible(true);
		this.addMouseListener(new MouseHandler());
		this.addMouseMotionListener(new MouseHandler());
		setSize(1100,600);
		addKeyListener(new AL());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setIconImage(W.getImage());
		setTitle("CRAZY SQUARES");
		rectSet = new ArrayList<Rectangle>();
		powerupSet = new ArrayList<Powerup>();
	}
	public class AL extends KeyAdapter implements KeyListener{
//		public void install(Component c){
//	        new AL(c);
//	    }
//
//	    public AL(Component c){
//	        c.addKeyListener(this);
//	    }
		public void keyPressed(KeyEvent e){
			int keyCode = e.getKeyCode();
			if(keyCode == KeyEvent.VK_RIGHT){
				isPressingRight = true;
			}
			if(keyCode == KeyEvent.VK_LEFT){
				isPressingLeft = true;
			}
			if(keyCode == KeyEvent.VK_UP){
				isPressingUp = true;
			}
			if(keyCode == KeyEvent.VK_DOWN){
				isPressingDown = true;
			}
			if(keyCode == KeyEvent.VK_D){
				isPressingD = true;
			}
			if(keyCode == KeyEvent.VK_A){
				isPressingA = true;
			}
			if(keyCode == KeyEvent.VK_W){
				isPressingW = true;
			}
			if(keyCode == KeyEvent.VK_S){
				isPressingS = true;
			}
			if(keyCode == KeyEvent.VK_J){
				isPressingJ = true;
			}
			if(keyCode == KeyEvent.VK_I){
				isPressingI = true;
			}
			if(keyCode == KeyEvent.VK_L){
				isPressingL = true;
			}
			if(keyCode == KeyEvent.VK_K){
				isPressingK = true;
			}
			if(keyCode == KeyEvent.VK_5){
				isPressing5 = true;
			}
			if(keyCode == KeyEvent.VK_F6){
				isPressingF6 = true;
			}
			if(keyCode == KeyEvent.VK_7){
				isPressing7 = true;
			}
			if(keyCode == KeyEvent.VK_6){
				isPressing6 = true;
			}
			if(keyCode == KeyEvent.VK_ESCAPE && (paused || showControls) && !isPressingESC){
				paused = false;
				showControls = false;
				hasGameStarted = false;
			}
			if(keyCode == KeyEvent.VK_ESCAPE && hasGameStarted){
				isPressingESC = true;
				paused = true;
			}
			if(keyCode == KeyEvent.VK_DELETE && paused){
				paused = false;
			}
			
//			if(keyCode == KeyEvent.VK_P){
//				isPressing5 = true;
//			}
//			if(keyCode == KeyEvent.VK_MINUS){
//				isPressingF6 = true;
//			}
//			if(keyCode == KeyEvent.VK_CLOSE_BRACKET){
//				isPressing7 = true;
//			}
//			if(keyCode == KeyEvent.VK_OPEN_BRACKET){
//				isPressing6 = true;
//			}
			if(keyCode == KeyEvent.VK_ENTER && gameOver){
				resetLevel();
				hasGameStarted = false;
			}
		}
		public void keyReleased(KeyEvent e){
			int keyCode = e.getKeyCode();
			if(keyCode == KeyEvent.VK_RIGHT){
				isPressingRight = false;
			}
			if(keyCode == KeyEvent.VK_LEFT){
				isPressingLeft = false;
			}
			if(keyCode == KeyEvent.VK_UP){
				isPressingUp = false;
			}
			if(keyCode == KeyEvent.VK_DOWN){
				isPressingDown = false;
			}
			if(keyCode == KeyEvent.VK_D){
				isPressingD = false;
			}
			if(keyCode == KeyEvent.VK_A){
				isPressingA = false;
			}
			if(keyCode == KeyEvent.VK_W){
				isPressingW = false;
			}
			if(keyCode == KeyEvent.VK_S){
				isPressingS = false;
			}
			if(keyCode == KeyEvent.VK_J){
				isPressingJ = false;
			}
			if(keyCode == KeyEvent.VK_I){
				isPressingI = false;
			}
			if(keyCode == KeyEvent.VK_L){
				isPressingL = false;
			}
			if(keyCode == KeyEvent.VK_K){
				isPressingK = false;
			}
			if(keyCode == KeyEvent.VK_5){
				isPressing5 = false;
			}
			if(keyCode == KeyEvent.VK_F6){
				isPressingF6 = false;
			}
			if(keyCode == KeyEvent.VK_7){
				isPressing7 = false;
			}
			if(keyCode == KeyEvent.VK_6){
				isPressing6 = false;
			}
			if(keyCode == KeyEvent.VK_ESCAPE && hasGameStarted){
				isPressingESC = false;
			}
//			if(keyCode == KeyEvent.VK_P){
//				isPressing5 = false;
//			}
//			if(keyCode == KeyEvent.VK_MINUS){
//				isPressingF6 = false;
//			}
//			if(keyCode == KeyEvent.VK_CLOSE_BRACKET){
//				 = false;
//			}
//			if(keyCode == KeyEvent.VK_OPEN_BRACKET){
//				isPressing6 = false;
//			}
		}
	}	
	public void paint(Graphics g){
		dbImage = createImage(getWidth(), getHeight());
		dbg = dbImage.getGraphics();
		paintComponent(dbg);
		g.drawImage(dbImage, 0, 0, this);
	}
	public static void main(String[] args){
		CrazySquares firstGame = new CrazySquares();
		Thread t1 = new Thread(firstGame);
		t1.start();
	}
	
	public void drawTopBar(Graphics g){
		g.setColor(new Color(70, 70, 70));
		g.fillRect(-100, -100, 2000,200);
		g.setColor(Color.WHITE);
		if(!suddenDeath){
			g.setFont(new Font("Arial", Font.PLAIN, 70));
			if(levelSeconds > 9){
				g.drawString(levelMinutes + ":" + levelSeconds, 480, 90);
			} else {
				g.drawString(levelMinutes + ":0" + levelSeconds, 480, 90);
			}
		} else {
			g.setFont(new Font("Arial", Font.PLAIN, 43));
			g.drawString("SUDDEN DEATH!", 375, 83);
		}
		if(twoPlayerGame){
			g.setFont(new Font("Arial", Font.PLAIN, 40));
			DecimalFormat df = new DecimalFormat("#0.0"); 
			g.setColor(Color.BLUE);
			g.drawString(df.format(redTime / 1000.0) + "", 245, 80);
			g.setColor(Color.RED);
			g.drawString(df.format(blueTime / 1000.0) + "", 800, 80);
			g.setFont(new Font("Arial", Font.PLAIN, 70));
			g.drawString(blueScore + "", 20, 90);
			g.setColor(Color.BLUE);
			if(redScore < 10){
				g.drawString(redScore + "", 1040, 90);
			} else if(redScore < 100){
				g.drawString(redScore + "", 1000, 90);
			} else {
				g.drawString(redScore + "", 960, 90);
			}
			g.setColor(Color.BLACK);
			g.fillRect(170, 0, 3, 100);
			g.fillRect(370, 0, 3, 100);
			g.fillRect(730, 0, 3, 100);
			g.fillRect(920, 0, 3, 100);
		} else if(threePlayerGame){
			g.setFont(new Font("Arial", Font.PLAIN, 40));
			DecimalFormat df = new DecimalFormat("#0.0"); 
			g.setColor(Color.RED);
			g.drawString(df.format(redTime / 1000.0) + "", 980, 80);
			g.setColor(Color.BLUE);
			g.drawString(df.format(blueTime / 1000.0) + "", 870, 80);
			g.setColor(Color.YELLOW);
			g.drawString(df.format(yellowTime / 1000.0) + "", 760, 80);
			g.setFont(new Font("Arial", Font.PLAIN, 70));
			g.setColor(Color.BLUE);
			g.drawString(blueScore + "", 50, 90);
			g.setColor(Color.RED);
			g.drawString(redScore + "", 180, 90);
			g.setColor(Color.YELLOW);
			g.drawString(yellowScore + "", 300, 90);
		} else if(fourPlayerGame){
			DecimalFormat df = new DecimalFormat("#0.0"); 
			if(suddenDeath){
				g.setFont(new Font("Arial", Font.PLAIN, 30));
				g.setColor(Color.RED);
				g.drawString(df.format(redTime / 1000.0) + "", 1000, 80);
				g.setColor(Color.BLUE);
				g.drawString(df.format(blueTime / 1000.0) + "", 920, 80);
				g.setColor(Color.YELLOW);
				g.drawString(df.format(yellowTime / 1000.0) + "", 840, 80);
				g.setColor(Color.GREEN);
				g.drawString(df.format(greenTime / 1000.0) + "", 760, 80);
			} else {
				g.setFont(new Font("Arial", Font.PLAIN, 40));
				g.setColor(Color.RED);
				g.drawString(df.format(redTime / 1000.0) + "", 980, 80);
				g.setColor(Color.BLUE);
				g.drawString(df.format(blueTime / 1000.0) + "", 870, 80);
				g.setColor(Color.YELLOW);
				g.drawString(df.format(yellowTime / 1000.0) + "", 760, 80);
				g.setColor(Color.GREEN);
				g.drawString(df.format(greenTime / 1000.0) + "", 650, 80);
			}
			if(suddenDeath){
				g.setFont(new Font("Arial", Font.PLAIN, 50));
				g.setColor(Color.BLUE);
				g.drawString(blueScore + "", 50, 85);
				g.setColor(Color.RED);
				g.drawString(redScore + "", 140, 85);
				g.setColor(Color.YELLOW);
				g.drawString(yellowScore + "", 230, 85);
				g.setColor(Color.GREEN);
				g.drawString(greenScore + "", 320, 85);
			} else {
				g.setFont(new Font("Arial", Font.PLAIN, 60));
				g.setColor(Color.BLUE);
				g.drawString(blueScore + "", 50, 90);
				g.setColor(Color.RED);
				g.drawString(redScore + "", 160, 90);
				g.setColor(Color.YELLOW);
				g.drawString(yellowScore + "", 270, 90);
				g.setColor(Color.GREEN);
				g.drawString(greenScore + "", 380, 90);
			}
		}
		
	}
	
	public void scoreHandler(){
		int time = 0;
		if(twoPlayerGame){
			time = 5000;
		} else if(threePlayerGame){
			time = 4000;
		} else if(fourPlayerGame){
			time = 3000;
		}
		if(blueTime == time){
			blueScoring = true;
			blueScore++;
		} 
		if(blueTime < time){
			blueScoring = false;
		}
		if(redTime == time){
			redScoring = true;
			redScore++;
		} 
		if(redTime < time){
			redScoring = false;
		}
		if(yellowTime == time){
			yellowScoring = true;
			yellowScore++;
		} 
		if(yellowTime < time){
			yellowScoring = false;
		}
		if(greenTime == time){
			greenScoring = true;
			greenScore++;
		} 
		if(greenTime < time){
			greenScoring = false;
		}
	}
	
	public void setBall(){
		for(Rectangle rect : rectSet){
			rect.x += 535 - ballX;
			rect.y += 315 - ballY;
		}
		ballX += 535 - ballX;
		ballY += 315 - ballY;
	}
	
	public void createPowerup(){
		Random rand = new Random();
		if(!suddenDeath && !paused){
			powerupCount++;
			//System.out.println("powerupCount");
			if(powerupCount >= 2800){
				powerupCount = 0;
				int randNum = rand.nextInt(2);
				if(randNum == 0 || randNum == 1){
					boolean foundXY = false;
					while(!foundXY){
						int x = rand.nextInt(1200);
						int y = rand.nextInt(600);
						//System.out.println("(" + x + ", " + y + ")" + foundXY);
						Rectangle temp1 = new Rectangle(blueX - 50, blueY- 50, blueDim + 100, blueDim + 100);
						Rectangle temp2 = new Rectangle(redX - 50, redY - 50, redDim + 100, redDim + 100);
						Rectangle temp3 = new Rectangle(yellowX - 50, yellowY - 50, yellowDim + 100, yellowDim + 100);
						Rectangle temp5 = new Rectangle(greenX - 50, greenY - 50, greenDim + 100, greenDim + 100);
						Rectangle temp4 = new Rectangle(x, y, 15, 15);
						if(!temp1.intersects(temp4) && !temp2.intersects(temp4) && !temp3.intersects(temp4) && !temp5.intersects(temp4)
								&& y > 100 && y < 550 && x > 50 && x < 1000){
							foundXY = true;
						
							int randNum2 = rand.nextInt(3);
							if(randNum2 == 0){
								powerupSet.add(new Powerup(x, y, 15, 15, "speed"));
							} else if(randNum2 == 1){
								powerupSet.add(new Powerup(x, y, 15, 15, "bigger"));
							} else if(randNum2 == 2){
								powerupSet.add(new Powerup(x, y, 15, 15, "onFire"));
							}
						}
					}
				}
			}
		}
	}
	
	public void drawPowerups(Graphics g){
		for(Powerup pu : powerupSet){
			if(pu.type.equals("speed")){
				g.setColor(new Color(69, 236, 169));
			} else if(pu.type.equals("bigger")){
				g.setColor(new Color(236, 147, 69));
			}
			 else if(pu.type.equals("onFire")){
				g.setColor(new Color(191, 69, 236));
			}
			g.fillRect(pu.x, pu.y, pu.width, pu.height);
		}
	}
	
	public void powerupTest(){
		if(!suddenDeath){
			for(int i = 0; i < powerupSet.size(); i++){
				Rectangle temp1 = new Rectangle(powerupSet.get(i).x, powerupSet.get(i).y, powerupSet.get(i).width, powerupSet.get(i).height);
				if(temp1.intersects(new Rectangle(blueX, blueY, blueDim, blueDim))){
					if(powerupSet.get(i).type.equals("speed")){
						blueSpeed = 1;
						blueMoveCount = 0;
						powerupSet.remove(i);
						blueFaster = true;
					} else if(powerupSet.get(i).type.equals("bigger")){
						blueDim = 100;
						powerupSet.remove(i);
						blueBigger = true;
					}else if(powerupSet.get(i).type.equals("onFire")){
						powerupSet.remove(i);
						blueOnFire = true;
					}
				} 
				else if(temp1.intersects(new Rectangle(redX, redY, redDim, redDim))){
					if(powerupSet.get(i).type.equals("speed")){
						redSpeed = 1;
						redMoveCount = 0;
						powerupSet.remove(i);
						redFaster = true;
					} else if(powerupSet.get(i).type.equals("bigger")){
						redDim = 100;
						powerupSet.remove(i);
						redBigger = true;
					} else if(powerupSet.get(i).type.equals("onFire")){
						powerupSet.remove(i);
						redOnFire = true;
					}
				}
				else if(temp1.intersects(new Rectangle(yellowX, yellowY, yellowDim, yellowDim))){
					if(powerupSet.get(i).type.equals("speed")){
						yellowSpeed = 1;
						yellowMoveCount = 0;
						powerupSet.remove(i);
						yellowFaster = true;
					} else if(powerupSet.get(i).type.equals("bigger")){
						yellowDim = 100;
						powerupSet.remove(i);
						yellowBigger = true;
					} else if(powerupSet.get(i).type.equals("onFire")){
						powerupSet.remove(i);
						yellowOnFire = true;
					}
				}else if(temp1.intersects(new Rectangle(greenX, greenY, greenDim, greenDim))){
					if(powerupSet.get(i).type.equals("speed")){
						greenSpeed = 1;
						greenMoveCount = 0;
						powerupSet.remove(i);
						greenFaster = true;
					} else if(powerupSet.get(i).type.equals("bigger")){
						greenDim = 100;
						powerupSet.remove(i);
						greenBigger = true;
					} else if(powerupSet.get(i).type.equals("onFire")){
						powerupSet.remove(i);
						greenOnFire = true;
					}
				}
			}
			if(blueFaster){
				blueFasterCount++;
				if(blueFasterCount == 4000){
					blueFasterCount = 0;
					blueSpeed = 2;
					blueFaster = false;
				}
			}
			if(redFaster){
				redFasterCount++;
				if(redFasterCount == 4000){
					redFasterCount = 0;
					redSpeed = 2;
					redFaster = false;
				}
			}
			if(yellowFaster){
				yellowFasterCount++;
				if(yellowFasterCount == 4000){
					yellowFasterCount = 0;
					yellowSpeed = 2;
					yellowFaster = false;
				}
			}
			if(greenFaster){
				greenFasterCount++;
				if(greenFasterCount == 4000){
					greenFasterCount = 0;
					greenSpeed = 2;
					greenFaster = false;
				}
			}
			if(blueBigger){
				blueBiggerCount++;
				if(blueBiggerCount == 4000){
					blueBiggerCount = 0;
					blueBigger = false;
					blueDim = 50;
				}
			}
			if(redBigger){
				redBiggerCount++;
				if(redBiggerCount == 4000){
					redBiggerCount = 0;
					redBigger = false;
					redDim = 50;
				}
			}
			if(yellowBigger){
				yellowBiggerCount++;
				if(yellowBiggerCount == 4000){
					yellowBiggerCount = 0;
					yellowBigger = false;
					yellowDim = 50;
				}
			}
			if(greenBigger){
				greenBiggerCount++;
				if(greenBiggerCount == 4000){
					greenBiggerCount = 0;
					greenBigger = false;
					greenDim = 50;
				}
			}
			if(blueOnFire){
				blueOnFireCount++;
				if(blueOnFireCount == 3000){
					blueOnFireCount = 0;
					blueOnFire = false;
				}
			}
			if(redOnFire){
				redOnFireCount++;
				if(redOnFireCount == 3000){
					redOnFireCount = 0;
					redOnFire = false;
				}
			}
			if(yellowOnFire){
				yellowOnFireCount++;
				if(yellowOnFireCount == 3000){
					yellowOnFireCount = 0;
					yellowOnFire = false;
				}
			}
			if(greenOnFire){
				greenOnFireCount++;
				if(greenOnFireCount == 3000){
					greenOnFireCount = 0;
					greenOnFire = false;
				}
			}
		} else {
			blueBigger = true;
			blueFaster = true;
			blueOnFire = true;
			redBigger = true;
			redFaster = true;
			redOnFire = true;
			yellowBigger = true;
			yellowFaster = true;
			yellowOnFire = true;
			greenBigger = true;
			greenFaster = true;
			greenOnFire = true;
			blueMoveCount = 0;
			redMoveCount = 0;
			yellowMoveCount = 0;
			greenMoveCount = 0;
			blueSpeed = 1;
			redSpeed = 1;
			yellowSpeed = 1;
			greenSpeed = 1;
			blueDim = 100;
			redDim = 100;
			yellowDim = 100;
			greenDim = 100;
		}
	}
	
	public void bigHandler(){
		Rectangle temp1 = new Rectangle(blueX + 5, blueY + 5, blueDim - 10, blueDim - 10);
		Rectangle temp2 = new Rectangle(ballX, ballY, 30, 30);
		boolean blueIntersecting = false;
		String direction = "";
		if(blueBigger && temp1.intersects(temp2)){
			if(blueX + blueX < 600 && blueY < 300){
				blueIntersecting = true;
				direction = "down";
			}
		}
		if(blueIntersecting){
			for(Rectangle rect : rectSet){
				if(direction.equals("down")){
					rect.y +=  100;
				}
			}
			ballY += 100;
			blueIntersecting = false;
		}		
	}
	
	public void pushHandler(){
		if(bluePushedLeft || bluePushedRight || bluePushedUp || bluePushedDown){
			bluePushCount++;
		}
		if(!bluePushedLeft && !bluePushedRight && !bluePushedUp && !bluePushedDown){
			bluePushCount = 0;
		}
		if(redPushedLeft || redPushedRight || redPushedUp || redPushedDown){
			redPushCount++;
		}
		if(!redPushedLeft && !redPushedRight && !redPushedUp && !redPushedDown){
			redPushCount = 0;
		}
		if(yellowPushedLeft || yellowPushedRight || yellowPushedUp || yellowPushedDown){
			yellowPushCount++;
		}
		if(!yellowPushedLeft && !yellowPushedRight && !yellowPushedUp && !yellowPushedDown){
			yellowPushCount = 0;
		}
		if(greenPushedLeft || greenPushedRight || greenPushedUp || greenPushedDown){
			greenPushCount++;
		}
		if(!greenPushedLeft && !greenPushedRight && !greenPushedUp && !greenPushedDown){
			greenPushCount = 0;
		}
		if(bluePushedLeft){
			if(bluePushCount >= 400 || suddenDeath){
				if(blueY < 250){
					blueY += 1;
				} else if(blueY >= 350){
					blueY -= 1;
				}
			}
		} else if(bluePushedRight){
			if(bluePushCount >= 400 || suddenDeath){
				if(blueY < 250){
					blueY += 1;
				} else if(blueY >= 350){
					blueY -= 1;
				}
			}
		}else if(bluePushedUp){
			if(bluePushCount >= 400 || suddenDeath){
				if(blueX < 450){
					blueX += 1;
				} else if(blueX >= 550){
					blueX -= 1;
				}
			}
		} else if(bluePushedDown){
			if(bluePushCount >= 400 || suddenDeath){
				if(blueX < 450){
					blueX += 1;
				} else if(blueX >= 550){
					blueX -= 1;
				}
			}
		}
		if(redPushedLeft){
			if(redPushCount >= 400 || suddenDeath){
				if(redY < 250){
					redY += 1;
				} else if(redY >= 350){
					redY -= 1;
				}
			}
		} else if(redPushedRight){
			if(redPushCount >= 400 || suddenDeath){
				if(redY < 250){
					redY += 1;
				} else if(redY >= 350){
					redY -= 1;
				}
			}
		}else if(redPushedUp){
			if(redPushCount >= 400 || suddenDeath){
				if(redX < 450){
					redX += 1;
				} else if(redX >= 550){
					redX -= 1;
				}
			}
		} else if(redPushedDown){
			if(redPushCount >= 400 || suddenDeath){
				if(redX < 450){
					redX += 1;
				} else if(redX >= 550){
					redX -= 1;
				}
			}
		}
		if(yellowPushedLeft){
			if(yellowPushCount >= 400 || suddenDeath){
				if(yellowY < 250){
					yellowY += 1;
				} else if(yellowY >= 350){
					yellowY -= 1;
				}
			}
		} else if(yellowPushedRight){
			if(yellowPushCount >= 400 || suddenDeath){
				if(yellowY < 250){
					yellowY += 1;
				} else if(yellowY >= 350){
					yellowY -= 1;
				}
			}
		}else if(yellowPushedUp){
			if(yellowPushCount >= 400 || suddenDeath){
				if(yellowX < 450){
					yellowX += 1;
				} else if(yellowX >= 550){
					yellowX -= 1;
				}
			}
		} else if(yellowPushedDown){
			if(yellowPushCount >= 400 || suddenDeath){
				if(yellowX < 450){
					yellowX += 1;
				} else if(yellowX >= 550){
					yellowX -= 1;
				}
			}
		}
		if(greenPushedLeft){
			if(greenPushCount >= 400 || suddenDeath){
				if(greenY < 250){
					greenY += 1;
				} else if(greenY >= 350){
					greenY -= 1;
				}
			}
		} else if(greenPushedRight){
			if(greenPushCount >= 400 || suddenDeath){
				if(greenY < 250){
					greenY += 1;
				} else if(greenY >= 350){
					greenY -= 1;
				}
			}
		}else if(greenPushedUp){
			if(greenPushCount >= 400 || suddenDeath){
				if(greenX < 450){
					greenX += 1;
				} else if(greenX >= 550){
					greenX -= 1;
				}
			}
		} else if(greenPushedDown){
			if(greenPushCount >= 400 || suddenDeath){
				if(greenX < 450){
					greenX += 1;
				} else if(greenX >= 550){
					greenX -= 1;
				}
			}
		}
	}
	
	public void resetLevel(){
		if(!suddenDeath){
		if(twoPlayerGame){
		    blueX = 1000;
		    blueY = 300;
		    redX = 50;
		    redY = 300;
			}
			if(threePlayerGame){
		      redX = 1000;
			   redY = 300;
			   blueX = 50;
			   blueY = 300;
			   yellowY = 500;
			   yellowX = 525;
			}
			if(fourPlayerGame){
				blueX = 50;
				blueY = 140;
				redX = 1000;
				redY = 140;
				yellowX = 50;
				greenY = 500;
				greenX = 1000;
			}
		}
	   // setBall();
		hasSetBall = false;
//		ballX += 245;
//		ballY += 110;
		levelMinutes = 2;
		levelSeconds = 0;
		redScore = 0;
		blueScore = 0;
		yellowScore = 0;
		greenScore = 0;
		powerupSet.clear();
		ballMovingRight = false;
		ballMovingRightCount = 0;
		ballMovingLeft = false;
		ballMovingLeftCount = 0;
		ballMovingUp = false;
		ballMovingUpCount = 0;
		ballMovingDown = false;
		ballMovingDownCount = 0;
		powerupCount = 0;
		blueBigger = false;
		blueFaster = false;
		blueOnFire = false;
		redBigger = false;
		redFaster = false;
		redOnFire = false;
		yellowBigger = false;
		yellowFaster = false;
		yellowOnFire = false;
		greenBigger = false;
		greenFaster = false;
		greenOnFire = false;
		blueDim = 50;
		redDim = 50;
		yellowDim = 50;
		greenDim = 50;
		blueSpeed = 2;
		redSpeed = 2;
		yellowSpeed = 2;
		greenSpeed = 2;
		blueMoveCount = 0;
		redMoveCount = 0;
		yellowMoveCount = 0;
		greenMoveCount = 0;
		
		blueKickedUp = false;
		blueKickedDown = false;
		blueKickedLeft = false;
		blueKickedRight = false;
		blueKickedUpCount = 0;
		blueKickedDownCount = 0;
		blueKickedLeftCount = 0;
		blueKickedRightCount = 0;
		redKickedUp = false;
		redKickedDown = false;
		redKickedLeft = false;
		redKickedRight = false;
		redKickedUpCount = 0;
		redKickedDownCount = 0;
		redKickedLeftCount = 0;
		redKickedRightCount = 0;
		yellowKickedUp = false;
		yellowKickedDown = false;
		yellowKickedLeft = false;
		yellowKickedRight = false;
		yellowKickedUpCount = 0;
		yellowKickedDownCount = 0;
		yellowKickedLeftCount = 0;
		yellowKickedRightCount = 0;
		greenKickedUp = false;
		greenKickedDown = false;
		greenKickedLeft = false;
		greenKickedRight = false;
		greenKickedUpCount = 0;
		greenKickedDownCount = 0;
		greenKickedLeftCount = 0;
		greenKickedRightCount = 0;
		
		suddenDeathAdjust = false;			
		if(gameOver){
			gameOver = false;
			if(redWin || blueWin || yellowWin || greenWin){
				suddenDeath = false;
				redWin = false;
				blueWin = false;
				yellowWin = false;
				greenWin = false;
			}
		}
//		if(!suddenDeathAdjust && suddenDeath){
//			suddenDeathAdjust = true;
//			if(twoPlayerGame){
//				blueX = 950;
//			} else if(threePlayerGame){
//				redX = 950;
//				yellowX = 500;
//				yellowY = 475;
//			}
//		}
	}
	
	public void suddenDeathAdjust(){
		if(twoPlayerGame){
			blueX = 950;
			redX= 50;
			blueY = 300;
			redY = 300;
		} else if(threePlayerGame){
			blueX = 50;
			redY = 300;
			blueY = 300;
			redX = 950;
			yellowX = 500;
			yellowY = 475;
		} else if(fourPlayerGame){
			blueX = 50;
			blueY = 140;
			redX = 950;
			redY = 140;
			yellowY = 450;
			yellowX = 50;
			greenY = 450;
			greenX = 950;
			
			System.out.println("sdfs");
		}
	}
	
	public void paintComponent(Graphics g){
		//x = sqrt((r^2)-((y-b)^2)) - a
		//y = sqrt((r^2)-((x-a)^2)) - b
		Random randy = new Random();
		
		//TWO PLAYERS
		if(hasGameStarted && twoPlayerGame){
		g.setColor(new Color(150, 0, 0));
		g.fillRect(600, -100, 1000, 1000);
		g.setColor(new Color(0, 0, 150));
		g.fillRect(-100, -100, 600, 1000);
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(500, -100, 100, 1000);
		if(!blueOnFire){
			g.setColor(Color.BLUE);
		} else {
			g.setColor(new Color(randy.nextInt(251), randy.nextInt(251), randy.nextInt(251)));
		}
		g.fillRect(blueX, blueY, blueDim, blueDim);
		if(!redOnFire){
			g.setColor(Color.RED);
		} else {
			g.setColor(new Color(randy.nextInt(251), randy.nextInt(251), randy.nextInt(251)));
		}
		g.fillRect(redX, redY, redDim, redDim);
		if(!createdBall){
			createBall();
			createdBall = true;
		}	
		if(!hasSetBall){
			setBall();
			hasSetBall = true;
		}
		g.setColor(Color.MAGENTA);
		drawBall(g);
		g.setColor(Color.BLACK);
		if(blueOnFire){
			g.setColor(Color.BLUE);
		}
		g.drawRect(blueX, blueY, blueDim, blueDim);
		g.setColor(Color.BLACK);
		if(redOnFire){
			g.setColor(Color.RED);
		}
		g.drawRect(redX, redY, redDim, redDim);
	//	g.drawOval(ballX, ballY, 30, 30);
	//	g.drawOval(ballX - 1, ballY - 1, 32, 32);
		//g.drawRect(ballX, ballY, ballDiam, ballDiam);
		g.setFont(new Font("Arial", Font.PLAIN, 20));
		//g.drawString(blueY + "", 200, 300);
	//	g.drawString(redTime / 1000.0 + "", 200, 130);
		drawTopBar(g);
		createPowerup();
		drawPowerups(g);
		powerupTest();
		bigHandler();
		} 
		// THREE PLAYERS
		if(hasGameStarted && threePlayerGame){
			if(!setSquaresThree && !suddenDeath){
				setSquaresThree = true;
				blueX = 50;
				redX = 1000;
			}
			g.setColor(new Color(0, 0, 150));
			g.fillRect(550, -100, 600, 400);
			g.fillRect(650, -100, 600, 540);
			g.setColor(new Color(150, 0, 0));
			g.fillRect(-100, -100, 650, 400);
			g.fillRect(-100, -100, 550, 540);
			g.setColor(new Color(200, 200, 0));
			g.fillRect(-100, 440, 1300, 400);
			g.fillRect(450, 360, 200, 80);
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(450, 300, 200, 60);
			if(!blueOnFire){
				g.setColor(Color.BLUE);
			} else {
				g.setColor(new Color(randy.nextInt(251), randy.nextInt(251), randy.nextInt(251)));
			}
			g.fillRect(blueX, blueY, blueDim, blueDim);
			if(!redOnFire){
				g.setColor(Color.RED);
			} else {
				g.setColor(new Color(randy.nextInt(251), randy.nextInt(251), randy.nextInt(251)));
			}
			g.fillRect(redX, redY, redDim, redDim);
			if(!yellowOnFire){
				g.setColor(Color.yellow);
			} else {
				g.setColor(new Color(randy.nextInt(251), randy.nextInt(251), randy.nextInt(251)));
			}
			g.fillRect(yellowX, yellowY, yellowDim, yellowDim);
			g.setColor(Color.BLACK);
			if(blueOnFire){
				g.setColor(Color.BLUE);
			}
			g.drawRect(blueX, blueY, blueDim, blueDim);
			g.setColor(Color.BLACK);
			if(redOnFire){
				g.setColor(Color.RED);
			}
			g.drawRect(redX, redY, redDim, redDim);
			g.setColor(Color.BLACK);
			if(yellowOnFire){
				g.setColor(Color.YELLOW);
			}
			g.drawRect(yellowX, yellowY, yellowDim, yellowDim);
			drawTopBar(g);
			if(!createdBall){
				createBall();
				createdBall = true;
			}
			if(!hasSetBall){
				setBall();
				hasSetBall = true;
			}
			g.setColor(Color.MAGENTA);
			drawBall(g);
			createPowerup();
			drawPowerups(g);
			powerupTest();
			bigHandler();
			g.setColor(Color.BLACK);
			//g.drawString(isPressingI + "", 100, 100);
		}
		if(hasGameStarted && fourPlayerGame){
			if(!setSquaresFour && !suddenDeath){
				setSquaresFour = true;
				blueX = 50;
				blueY = 140;
				redX = 1000;
				redY = 140;
				yellowX = 50;
				greenY = 500;
				greenX = 1000;
			}
			g.setColor(new Color(0, 0, 150));
			g.fillRect(0, 0, 510, 300);
			g.setColor(new Color(150, 0, 0));
			g.fillRect(590, 0, 510, 300);
			g.setColor(new Color(200, 200, 0));
			g.fillRect(0, 370, 510, 300);
			g.setColor(new Color(0, 150, 0));
			g.fillRect(590, 370, 510, 290);
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(510, 0, 80, 600);
			g.fillRect(0, 300, 2000, 70);
			if(!blueOnFire){
				g.setColor(Color.BLUE);
			} else {
				g.setColor(new Color(randy.nextInt(251), randy.nextInt(251), randy.nextInt(251)));
			}
			g.fillRect(blueX, blueY, blueDim, blueDim);
			if(!redOnFire){
				g.setColor(Color.RED);
			} else {
				g.setColor(new Color(randy.nextInt(251), randy.nextInt(251), randy.nextInt(251)));
			}
			g.fillRect(redX, redY, redDim, redDim);
			if(!yellowOnFire){
				g.setColor(Color.yellow);
			} else {
				g.setColor(new Color(randy.nextInt(251), randy.nextInt(251), randy.nextInt(251)));
			}
			g.fillRect(yellowX, yellowY, yellowDim, yellowDim);
			if(!greenOnFire){
				g.setColor(Color.green);
			} else {
				g.setColor(new Color(randy.nextInt(251), randy.nextInt(251), randy.nextInt(251)));
			}
			g.fillRect(greenX, greenY, greenDim, greenDim);
			g.setColor(Color.BLACK);
			if(blueOnFire){
				g.setColor(Color.BLUE);
			}
			g.drawRect(blueX, blueY, blueDim, blueDim);
			g.setColor(Color.BLACK);
			if(redOnFire){
				g.setColor(Color.RED);
			}
			g.drawRect(redX, redY, redDim, redDim);
			g.setColor(Color.BLACK);
			if(yellowOnFire){
				g.setColor(Color.YELLOW);
			}
			g.drawRect(yellowX, yellowY, yellowDim, yellowDim);
			g.setColor(Color.BLACK);
			if(greenOnFire){
				g.setColor(Color.GREEN);
			}
			g.drawRect(greenX, greenY, greenDim, greenDim);
			drawTopBar(g);
			if(!createdBall){
				createBall();
				createdBall = true;
			}
			if(!hasSetBall){
				setBall();
				hasSetBall = true;
			}
			g.setColor(Color.MAGENTA);
			drawBall(g);
			createPowerup();
			drawPowerups(g);
			powerupTest();
			bigHandler();
			g.setColor(Color.BLACK);
		}
		if(redWin ||  blueWin || yellowWin || greenWin){			
			if(redWin){
				g.setColor(new Color(0, 0, 0));
				g.fillRect(295, 195 ,510, 210);
				g.setColor(new Color(50, 50, 50));
				g.fillRect(300, 200,500, 200);
				g.setColor(Color.RED);
				g.setFont(new Font("Arial", Font.PLAIN, 80));
				g.drawString("RED WINS!", 340, 330);
			}
			if(blueWin){
				g.setColor(new Color(0, 0, 0));
				g.fillRect(295, 195 ,510, 210);
				g.setColor(new Color(50, 50, 50));
				g.fillRect(300, 200,500, 200);
				g.setColor(Color.BLUE);
				g.setFont(new Font("Arial", Font.PLAIN, 80));
				g.drawString("BLUE WINS!", 320, 330);
			}
			if(yellowWin){
				g.setColor(new Color(0, 0, 0));
				g.fillRect(235, 195 ,620, 210);
				g.setColor(new Color(50, 50, 50));
				g.fillRect(240, 200, 610, 200);	
				g.setColor(Color.YELLOW);
				g.setFont(new Font("Arial", Font.PLAIN, 80));
				g.drawString("YELLOW WINS!", 250, 330);
			} 
			if(greenWin){
				g.setColor(new Color(0, 0, 0));
				g.fillRect(270, 195 ,560, 210);
				g.setColor(new Color(50, 50, 50));
				g.fillRect(275, 200,550, 200);
				g.setColor(Color.GREEN);
				g.setFont(new Font("Arial", Font.PLAIN, 80));
				g.drawString("GREEN WINS!", 282, 330);
			}
			g.setFont(new Font("Arial", Font.PLAIN, 12));
			g.drawString("press enter to return to the title screen", 440, 380);
		}
		//TITLE SCREEN
		if(!hasGameStarted){
			g.setColor(new Color(50, 50, 200));
			g.fillRect(-100, -100, 2000, 1000);
			g.setFont(new Font("Arial", Font.PLAIN, 95));
			g.setColor(new Color(200, 50, 50));
			g.drawString("C", 115, 280);
         g.drawString("Z", 320, 280);
         g.drawString("Q", 555, 280);
         g.drawString("R", 760, 280);
			g.setColor(new Color(50, 200, 50));
			g.drawString("R", 180, 280);
         g.drawString("Y", 385, 280);
         g.drawString("U", 625, 280);
         g.drawString("E", 830, 280);
			g.setColor(new Color(200, 200, 50));
			g.drawString("A", 250, 280);
         g.drawString("S", 490, 280);
         g.drawString("A", 695, 280);
         g.drawString("S", 895, 280);
			g.setFont(new Font("Arial", Font.PLAIN, 30));
			if(twoPlayerHover){
				g.setColor(Color.YELLOW);
				g.fillRect(twoPlayerStartButton.x, twoPlayerStartButton.y, twoPlayerStartButton.width, twoPlayerStartButton.height);
				g.setColor(Color.RED);
				g.drawString("2 Players", 490, 360);
			} else {
				g.setColor(Color.RED);
				g.fillRect(twoPlayerStartButton.x, twoPlayerStartButton.y, twoPlayerStartButton.width, twoPlayerStartButton.height);
				g.setColor(Color.BLUE);
				g.drawString("2 Players", 490, 360);
			}
			if(twoPlayerSDHover){
				g.setColor(Color.YELLOW);
				g.fillRect(twoPlayerSDButton.x, twoPlayerSDButton.y, twoPlayerSDButton.width, twoPlayerSDButton.height);
				g.setColor(Color.RED);
				g.drawString("SD", 684, 360);
			} else {
				g.setColor(Color.RED);
				g.fillRect(twoPlayerSDButton.x, twoPlayerSDButton.y, twoPlayerSDButton.width, twoPlayerSDButton.height);
				g.setColor(Color.BLUE);
				g.drawString("SD", 684, 360);
			}
			if(threePlayerHover){
				g.setColor(Color.YELLOW);
				g.fillRect(threePlayerStartButton.x, threePlayerStartButton.y, threePlayerStartButton.width, threePlayerStartButton.height);
				g.setColor(Color.RED);
				g.drawString("3 Players", 490, 430);
			} else {
				g.setColor(Color.RED);
				g.fillRect(threePlayerStartButton.x, threePlayerStartButton.y, threePlayerStartButton.width, threePlayerStartButton.height);
				g.setColor(Color.BLUE);
				g.drawString("3 Players", 490, 430);
			}	
			if(threePlayerSDHover){
				g.setColor(Color.YELLOW);
				g.fillRect(threePlayerSDButton.x, threePlayerSDButton.y, threePlayerSDButton.width, threePlayerSDButton.height);
				g.setColor(Color.RED);
				g.drawString("SD", 684, 430);
			} else {
				g.setColor(Color.RED);
				g.fillRect(threePlayerSDButton.x, threePlayerSDButton.y, threePlayerSDButton.width, threePlayerSDButton.height);
				g.setColor(Color.BLUE);
				g.drawString("SD", 684, 430);
			}
			if(fourPlayerHover){
				g.setColor(Color.YELLOW);
				g.fillRect(fourPlayerStartButton.x, fourPlayerStartButton.y, fourPlayerStartButton.width, fourPlayerStartButton.height);
				g.setColor(Color.RED);
				g.drawString("4 Players", 490, 500);
			} else {
				g.setColor(Color.RED);
				g.fillRect(fourPlayerStartButton.x, fourPlayerStartButton.y, fourPlayerStartButton.width, fourPlayerStartButton.height);
				g.setColor(Color.BLUE);
				g.drawString("4 Players", 490, 500);
			}
			if(fourPlayerSDHover){
				g.setColor(Color.YELLOW);
				g.fillRect(fourPlayerSDButton.x, fourPlayerSDButton.y, fourPlayerSDButton.width, fourPlayerSDButton.height);
				g.setColor(Color.RED);
				g.drawString("SD", 684, 500);
			} else {
				g.setColor(Color.RED);
				g.fillRect(fourPlayerSDButton.x, fourPlayerSDButton.y, fourPlayerSDButton.width, fourPlayerSDButton.height);
				g.setColor(Color.BLUE);
				g.drawString("SD", 684, 500);
			}
			if(controlsHover){
				g.setColor(Color.YELLOW);
				g.fillRect(controlsButton.x, controlsButton.y, controlsButton.width, controlsButton.height);
				g.setColor(Color.RED);
				g.drawString("Controls", 535, 570);
			} else {
				g.setColor(Color.RED);
				g.fillRect(controlsButton.x, controlsButton.y, controlsButton.width, controlsButton.height);
				g.setColor(Color.BLUE);
				g.drawString("Controls", 535, 570);
			}
		}
		if(suddenDeathAlert){
			suddenDeathCount++;
			if(suddenDeathCount == 700){
				suddenDeathCount = 0;
				suddenDeathAlert = false;
			}
			g.setColor(new Color(0, 0, 0));
			g.fillRect(250, 195 ,590, 210);
			g.setColor(new Color(250, 250, 200));
			g.fillRect(255, 200,580, 200);	
			g.setColor(Color.BLACK);
			g.setFont(new Font("Arial", Font.PLAIN, 70));
			g.drawString("SUDDEN DEATH!", 255, 330);
		}
		//redX == 10 || redX == 9) && (blueX == redX + redDim || blueX == redX + redDim - 1) && isPressingLeft
		g.setColor(Color.BLACK);
		g.setFont(new Font("Arial", Font.PLAIN, 70));
		if(paused){
			g.drawString("Return To The Title Screen?", 100, 300);
			g.drawString("ESC = YES      DEL = NO", 130, 380);
		}
		if(showControls){
			g.setFont(new Font("Arial", Font.PLAIN, 50));
			g.setColor(new Color(80, 80, 80));
			g.fillRect(-10, -10, 2000, 1000);
			g.setColor(Color.BLUE);
			g.drawString("BLUE: Arrow Keys", 350, 150);
			g.setColor(Color.RED);
			g.drawString("RED: W A S D", 390, 250);
			g.setColor(Color.YELLOW);
			g.drawString("YELLOW: I J K L", 370, 350);
			g.setColor(Color.GREEN);
			g.drawString("GREEN: 5 6 7 F6", 365, 450);
			g.setColor(Color.WHITE);
			g.drawString("ESC - Return To The Title Screen", 200, 550);
		}
		pushHandler();
		repaint();
		counter++;
		//g.drawString(gameOver + "", 100, 100);
	}
}


