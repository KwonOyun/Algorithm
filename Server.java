package jagu7_2018;


public interface Server {
	public int getMeanServiceTime();
	public int getStopTime();
	public boolean isIdle();
	public void startServing(Client client, int t);
	public void stopServing(int t);
	public void SetExecutionTime(int x);
	public int GetExecutionTime();
}
