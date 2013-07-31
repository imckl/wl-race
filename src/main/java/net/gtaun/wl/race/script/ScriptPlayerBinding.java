package net.gtaun.wl.race.script;

import net.gtaun.shoebill.data.Color;
import net.gtaun.shoebill.object.Player;

public class ScriptPlayerBinding implements ScriptBinding
{
	private final Player player;
	
	public String name;
	
	
	public ScriptPlayerBinding(Player player)
	{
		this.player = player;
	}
	
	@Override
	public void update()
	{
		name = player.getName();
	}
	
	public void sendMessage(String message)
	{
		player.sendMessage(Color.WHITE, message);
	}
	
	public void setTime(int hours, int minutes)
	{
		player.setTime(hours, minutes);
	}
	
	public void setWeather(int weatherId)
	{
		player.setWeather(weatherId);
	}
}
