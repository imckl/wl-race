/**
 * Copyright (C) 2013 MK124
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License version 2 as
 * published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 */

package net.gtaun.wl.race.dialog;

import net.gtaun.shoebill.Shoebill;
import net.gtaun.shoebill.common.dialog.AbstractDialog;
import net.gtaun.shoebill.object.Player;
import net.gtaun.shoebill.resource.Plugin;
import net.gtaun.shoebill.resource.ResourceDescription;
import net.gtaun.util.event.EventManager;
import net.gtaun.wl.common.dialog.AbstractListDialog;
import net.gtaun.wl.common.dialog.MsgboxDialog;
import net.gtaun.wl.race.RaceServiceImpl;
import net.gtaun.wl.race.TrackManagerImpl;
import net.gtaun.wl.race.data.Track;

public class RaceDialog extends AbstractListDialog
{
	public RaceDialog
	(final Player player, final Shoebill shoebill, final EventManager eventManager, AbstractDialog parentDialog, final RaceServiceImpl raceService, final TrackManagerImpl trackManager)
	{
		super(player, shoebill, eventManager, parentDialog);
		this.caption = "赛车系统";

		dialogListItems.add(new DialogListItem("搜索赛道 ...")
		{
			@Override
			public void onItemSelect()
			{
				player.playSound(1083, player.getLocation());
			}
		});

		dialogListItems.add(new DialogListItem("赛道收藏夹 ...")
		{
			@Override
			public void onItemSelect()
			{
				player.playSound(1083, player.getLocation());
			}
		});

		dialogListItems.add(new DialogListItem("我的赛道 ...")
		{
			@Override
			public void onItemSelect()
			{
				player.playSound(1083, player.getLocation());
			}
		});

		dialogListItems.add(new DialogListItem("创建新赛道 ...")
		{
			@Override
			public void onItemSelect()
			{
				player.playSound(1083, player.getLocation());
				
				Track track = trackManager.createTrack();
				raceService.editTrack(player, track);
			}
		});

		dialogListItems.add(new DialogListItem("我的车手信息")
		{
			@Override
			public void onItemSelect()
			{
				player.playSound(1083, player.getLocation());
			}
		});

		dialogListItems.add(new DialogListItem("我的比赛记录 ...")
		{
			@Override
			public void onItemSelect()
			{
				player.playSound(1083, player.getLocation());
			}
		});

		dialogListItems.add(new DialogListItem("综合实力排名 ...")
		{
			@Override
			public void onItemSelect()
			{
				player.playSound(1083, player.getLocation());
			}
		});
		
		dialogListItems.add(new DialogListItem("帮助信息")
		{
			@Override
			public void onItemSelect()
			{
				player.playSound(1083, player.getLocation());
				String caption = String.format("%1$s: %2$s", "车管", "帮助信息");
				new MsgboxDialog(player, shoebill, eventManager, RaceDialog.this, caption, "偷懒中，暂无帮助信息……").show();
			}
		});
		
		dialogListItems.add(new DialogListItem("关于赛车系统")
		{
			@Override
			public void onItemSelect()
			{
				player.playSound(1083, player.getLocation());
				
				Plugin plugin = raceService.getPlugin();
				ResourceDescription desc = plugin.getDescription();
				
				String caption = String.format("%1$s: %2$s", "赛车", "关于赛车系统");
				String format =
					"--- 新未来世界 赛车系统组件 ---\n" +
					"版本: %1$s (Build %2$d)\n" +
					"编译时间: %3$s\n\n" +
					"开发: mk124\n" +
					"功能设计: mk124\n" +
					"设计顾问: 52_PLA(aka. Yin.J), [ITC]1314, [ITC]KTS\n" +
					"数据采集: mk124, 52_PLA\n" +
					"测试: 52_PLA, [ITC]1314, [ITC]KTS, SMALL_KR\n" +
					"感谢: vvg, yezhizhu, Luck, Waunny\n\n" +
					"本组件是新未来世界项目的一部分。\n" +
					"本组件使用 GPL v2 许可证开放源代码。\n" +
					"本组件禁止在任何商业或盈利性服务器上使用。\n";
				String message = String.format(format, desc.getVersion(), desc.getBuildNumber(), desc.getBuildDate());
				
				new MsgboxDialog(player, shoebill, eventManager, RaceDialog.this, caption, message).show();
			}
		});
	}
}
