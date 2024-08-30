package oberver;

public class Jump extends Observer{

	Jump(Subject sub){
		super(sub);
	}
	
	void doJump(){
		System.out.println("Jump!");
	}
	
	@Override
	public void update(){
		doJump();
	}
	

}
