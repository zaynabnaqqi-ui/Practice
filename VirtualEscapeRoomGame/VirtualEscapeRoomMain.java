import java.util.Scanner;

class Room {
    private String roomName;
    private String puzzle;
    private String answer;
    private boolean isSolved;

    public Room(String roomName, String puzzle, String answer, boolean isSolved){
       this.roomName = roomName;
       this.puzzle = puzzle;
       this.answer = answer;
       this.isSolved = isSolved;
    }
    public String getRoomName(){
        return roomName;
    }
    public String getPuzzle(){
        return puzzle;
    } 
    public String getAnswer(){
        return answer;
    } 
    public boolean getIsSolved(){
        return isSolved;
    }
    public void setIsSolved(boolean isSolved){
        this.isSolved= isSolved;
    }
}

class VirtualEscapeRoom{
    Scanner input = new Scanner(System.in);
    int roomCount;
    Room[] R =  new Room[5];

    {
       R[0] = new Room("Security Room", "I have a face and two hands, but no arms or legs. What am I?", "clock", false);
       R[1] = new Room("Code Chamber", "What comes once in a minute, twice in a moment, but never in a thousand years?", "m", false);
       R[2] = new Room("Final Exit", "What belongs to you but other people use it more than you do?", "name", false);
        roomCount = 3;
    }
    
    public Room createRoom() {
		 String roomName = input.nextLine();
		 String puzzle= input.nextLine();
		 String answer= input.nextLine(); 
		 boolean isSolved = false;  
		Room room = new Room(roomName, puzzle, answer, isSolved);
		return room;		
	}
    public Room findRoomByName(String roomName) {
    for (int i = 0; i < roomCount; i++) {
        if (roomName.equals(R[i].getRoomName())) {
            return R[i];
        }
    }
    return null;   
    }

    public void solvePuzzle(String roomName, String playerAnswer) {
        Room room = findRoomByName(roomName);
    
        if (room == null) {
            System.out.println("Error: Room '" + roomName + "' does not exist!");
            return;
        }
    
        if (room.getIsSolved()) {
            System.out.println("This puzzle has already been solved!");
            return;
        }
    
        String correctAnswer = room.getAnswer();
    
        if (correctAnswer.equals(playerAnswer)) {
            room.setIsSolved(true);
            System.out.println("Congratulations! You solved the puzzle!");
        } else {
            System.out.println("Error: Incorrect answer!");
        }
    }

	public void addRoom(Room r) {  
		if (roomCount<5) {
            R[roomCount++] = r;
            System.out.println("Room Added.");    
		}
		else {
			System.out.println("Not enough space");
		}
	}

    public void listUnsolvedRooms(){
        int count = 0;
        for (int i = 0; i < roomCount; i++) {
            if (!R[i].getIsSolved()) {
                System.out.print(i+1 + " ");
                System.out.println("Room: " + R[i].getRoomName());
                System.out.println("Puzzle: " + R[i].getPuzzle());
                System.out.println("  ");
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Congratulations! All rooms have been solved!");
        }
    }

}

public class VirtualEscapeRoomMain {
    public static void main(String[] args) {
        int c1,c2;
        Scanner in = new Scanner(System.in);

        VirtualEscapeRoom game = new VirtualEscapeRoom();

        while(true) {   

            System.out.println("\nWELCOME TO THE VIRTUAL ESCAPE ROOM GAME!");
            System.out.println("1. PLAY ------------------------ 2. ADD A ROOM ------------------3. EXIT.");
            System.out.print("Choose:");
            c1 = in.nextInt();

            if (c1 == 3) {        
                System.out.println("Thanks for playing! Goodbye!");
                break;
            }

            switch (c1) {
                case 1: {
                    System.out.println("1. Solve a Puzzle \n 2. List Unsolved Rooms \n 3. Exit Game");
                    System.out.print("Enter your choice:");
                    c2 = in.nextInt();
                    switch(c2){
                        case 1:
                            System.out.println("\nAvailable unsolved rooms:");
                            boolean anyUnsolved = false;
                            for (int i = 0; i < game.roomCount; i++) {
                                if (!game.R[i].getIsSolved()) {
                                    System.out.println(" - " + game.R[i].getRoomName());
                                    anyUnsolved = true;
                                }
                            }
                            if (!anyUnsolved) {
                                System.out.println("No unsolved rooms left!");
                                break;
                            }

                            System.out.print(" \nEnter room name: ");
                            in.nextLine(); 
                                            
                            String roomName = in.nextLine();
                                            
                            Room room = game.findRoomByName(roomName);
                            if (room != null) {
                                System.out.println("\nPuzzle: " + room.getPuzzle());
                                System.out.print("Your answer: ");
                                String answer = in.nextLine();
                                game.solvePuzzle(roomName, answer);
                            } else {
                                System.out.println("No room found.");
                            }
                            break;            
                        case 2:
                            game.listUnsolvedRooms();
                            break;
                                        
                        case 3:
                            System.out.println("Returning back!!");
                            break;
                                        
                        default:
                            System.out.println("WRONG INPUT.");
                            break;
                    }
                    break;  
                }
                case 2:{
                    Room r = game.createRoom();
                    game.addRoom(r);
                    break;
                }
                default:
                    System.out.println("WRONG INPUT!");
            }
        } 
    }
}