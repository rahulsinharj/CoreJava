package interfaceDemo3;

interface Actor
{
	void act();
	void speak();
	
	default void dance() 
	{
		System.out.println("Actor can dance as well");
	}
}

class Hero implements Actor
{
	@Override
	public void act() 
	{
		System.out.println("Hero can Act");
	}

	@Override
	public void speak() 
	{
		System.out.println("Hero can Speak");
	}
	
	public void comedy()
	{
		System.out.println("Hero can make people laugh");
	}
	
}

class Villain implements Actor
{
	@Override
	public void act() 
	{
		System.out.println("Villain can Act");
	}

	@Override
	public void speak() 
	{
		System.out.println("Villain can Speak");
	}
	
	public void rude()
	{
		System.out.println("Villain is Rude");
	}
	
}

public class InterfUsing_DefaultMethod 
{
	public static void main(String[] args) {
		
		Hero hero = new Hero();
		
		hero.act();
		hero.speak();
		hero.comedy();
		
		hero.dance();
		
		
	}
		
	
} 
