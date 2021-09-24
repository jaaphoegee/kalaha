public class Pit  implements Sower  {

	private Pit previousSower;
	private Pit nextSower;
	private Kalaha kalaha;
	private int balls;
	private int owningPlayer;
	private int pitNumber;
	private static final int EMPTY_BALLS_THRESHOLD = 3;


	public Pit(int pitNumber, int balls, int owningPlayer, Kalaha kalaha) {
		this.pitNumber = pitNumber;
		this.balls = balls;
		this.owningPlayer = owningPlayer;
		this.kalaha = kalaha;
	}

	public void setNextSower (Pit nextSower){
		this.nextSower = nextSower;
	}

	public void setPreviousSower (Pit previousSower){
		this.previousSower =  previousSower;
	}


	@Override
	public void sow(int player, int balls) {

		this.balls++;

		if ( player != owningPlayer
			&& balls <= EMPTY_BALLS_THRESHOLD)
		{

		}
		if (balls > 1 )
		{
			nextSower.sow(player, balls-1);
		}

	}

	public void empty(int player) {
		if ( balls > 0) {
			nextSower.sow(player, balls);
			balls = 0;
		}
	}


}
