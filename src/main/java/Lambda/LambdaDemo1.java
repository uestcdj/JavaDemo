package Lambda;

public class LambdaDemo1 {
	public static void main(String[] args) {
	new Thread(new Runnable() {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
	}).start();;
	
	new Thread(
			() -> System.out.println("nmb")
		).start();
	}
}
