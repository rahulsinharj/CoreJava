package interfaces.demoInterface1;

interface Actor
{
	void act();
	void speak();
}

class Hero implements Actor
{
	@Override
	public void act() 
	{
		System.out.println("I can Act");
	}

	@Override
	public void speak() 
	{
		System.out.println("I can Speak");
	}
	
	public void comedy()									// Hero class can have its own method also , apart from interface abstract methods 
	{
		System.out.println("I can make people laugh");
	}
	
}

class Villain implements Actor
{
	@Override
	public void act() 
	{
		System.out.println("I can Act");
	}

	@Override
	public void speak() 
	{
		System.out.println("I can Speak");
	}
	
	public void rude()								// Villain class can have its own method also , apart from interface abstract methods 
	{
		System.out.println("I am Rude");
	}
	
}

public class Normal_Interface {

	public static void main(String[] args) {
	
		Actor actor = new Hero();
		actor.act();
		actor.speak();

	}

}
