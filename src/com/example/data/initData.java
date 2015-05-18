package com.example.data;

import java.util.ArrayList;
import java.util.List;

import com.example.menu.R;

public class initData {
	public static List<String> getInitSql()
	{
		String insertSql = "";
		List<String> listSql = new ArrayList<String>();
		insertSql = "insert into NeedInfo (TitleName, TaskRequirement, Heavy, OtherWelfare, TaskAddress,TaskAddressLa,TaskAddressLo,BeginDate ,EndDate ,Telephone ,Stars, Charges, IsRealname, ImageName, start, end) "
				+ "values('紫金悦城', "
				+ "'80公里，环街骑行，提供衣物旗帜，自备车辆。提供热水，洗浴等',"
				+ "0,"
				+ "'提供午餐',"
				+ "'河北石家庄长安区紫金悦城',"
				+"114.559565,"
				+"38.065239,"
				+"'2015.03.02',"
				+"'2015.03.07',"
				+"'13513511669',"
				+ "3,"
				+ "500,"
				+ "1,"
				+ "'image1',"
				+ "0,"
				+ "2);";
		listSql.add(insertSql);
		insertSql = "insert into NeedInfo (TitleName, TaskRequirement, Heavy, OtherWelfare, TaskAddress,TaskAddressLa,TaskAddressLo,BeginDate ,EndDate ,Telephone ,Stars, Charges, IsRealname, ImageName, start, end) "
				+ "values('搜秀城购物广场', "
				+ "'20公里，环街骑行，提供衣物旗帜，自备车辆。提供热水，洗浴等',"
				+ "0,"
				+ "'提供午餐',"
				+ "'北京市东城区崇文门外大街40号',"
				+"116.425703,"
				+"39.902722,"
				+"'2015.03.02',"
				+"'2015.03.07',"
				+"'13513511669',"
				+ "3,"
				+ "300,"
				+ "1,"
				+ "'image2',"
				+ "0,"
				+ "2);";
		listSql.add(insertSql);
		insertSql = "insert into NeedInfo (TitleName, TaskRequirement, Heavy, OtherWelfare, TaskAddress,TaskAddressLa,TaskAddressLo,BeginDate ,EndDate ,Telephone ,Stars, Charges, IsRealname, ImageName, start, end) "
				+ "values('白沙源风景区', "
				+ "'30公里，环街骑行，提供衣物旗帜，自备车辆。提供热水，洗浴等',"
				+ "0,"
				+ "'提供午餐',"
				+ "'北京市朝阳区三丰北里',"
				+"116.445977,"
				+"39.927556,"
				+"'2015.06.01',"
				+"'2015.06.30',"
				+"'13513511669',"
				+ "3,"
				+ "300,"
				+ "1,"
				+ "'image6',"
				+ "0,"
				+ "2);";
		listSql.add(insertSql);
		insertSql = "insert into NeedInfo (TitleName, TaskRequirement, Heavy, OtherWelfare, TaskAddress,TaskAddressLa,TaskAddressLo,BeginDate ,EndDate ,Telephone ,Stars, Charges, IsRealname, ImageName, start, end) "
				+ "values('川酷麻辣香锅（延庆店）', "
				+ "'51公里，环街骑行，提供衣物旗帜，自备车辆。提供热水，洗浴等',"
				+ "0,"
				+ "'提供午餐',"
				+ "'延庆东外大街111号时代广场C座4层',"
				+"115.983064,"
				+"40.465481,"
				+"'2015.06.02',"
				+"'2015.12.07',"
				+"'15802165372',"
				+ "4,"
				+ "420,"
				+ "1,"
				+ "'image3',"
				+ "0,"
				+ "2);";
		listSql.add(insertSql);
		insertSql = "insert into NeedInfo (TitleName, TaskRequirement, Heavy, OtherWelfare, TaskAddress,TaskAddressLa,TaskAddressLo,BeginDate ,EndDate ,Telephone ,Stars, Charges, IsRealname, ImageName, start, end) "
				+ "values('宠物医院', "
				+ "'19公里，爱心宣传，出席媒体活动，需提供照片。提供热水、洗浴、衣服等',"
				+ "0,"
				+ "'提供午餐',"
				+ "'北京市海淀区银泉路双泉堡125号',"
				+"116.364218,"
				+"40.020869,"
				+"'2015.03.02',"
				+"'2015.03.07',"
				+"'13513511669',"
				+ "3,"
				+ "260,"
				+ "1,"
				+ "'image4',"
				+ "0,"
				+ "2);";
		listSql.add(insertSql);
		insertSql = "insert into NeedInfo (TitleName, TaskRequirement, Heavy, OtherWelfare, TaskAddress,TaskAddressLa,TaskAddressLo,BeginDate ,EndDate ,Telephone ,Stars, Charges, IsRealname, ImageName, start, end) "
				+ "values('喜临门家居', "
				+ "'120公里，爱心宣传，出席媒体活动，需提供照片。提供热水、洗浴、衣服等',"
				+ "5,"
				+ "'提供午餐',"
				+ "'北京市朝阳区东四环南路9号北京燕莎奥特莱斯',"
				+"116.492552,"
				+"39.883298,"
				+"'2015.06.02',"
				+"'2015.10.01',"
				+"'15303598702',"
				+ "3,"
				+ "310,"
				+ "1,"
				+ "'image5',"
				+ "0,"
				+ "3);";
		listSql.add(insertSql);
		insertSql = "insert into NeedInfo (TitleName, TaskRequirement, Heavy, OtherWelfare, TaskAddress,TaskAddressLa,TaskAddressLo,BeginDate ,EndDate ,Telephone ,Stars, Charges, IsRealname, ImageName, start, end) "
				+ "values('悠唐生活', "
				+ "'15公里，爱心宣传，出席媒体活动，需提供照片。提供热水、洗浴、衣服等',"
				+ "6,"
				+ "'提供午餐',"
				+ "'四川省成都神甫大道',"
				+"116.445977,"
				+"39.927556,"
				+"'2015.06.02',"
				+"'2015.10.01',"
				+"'15958147521',"
				+ "3,"
				+ "540,"
				+ "1,"
				+ "'image2',"
				+ "0,"
				+ "2);";
		listSql.add(insertSql);
		insertSql = "insert into NeedInfo (TitleName, TaskRequirement, Heavy, OtherWelfare, TaskAddress,TaskAddressLa,TaskAddressLo,BeginDate ,EndDate ,Telephone ,Stars, Charges, IsRealname, ImageName, start, end) "
				+ "values('山东大学齐鲁软件学院', "
				+ "'15公里，爱心宣传，出席媒体活动，需提供照片。提供热水、洗浴、衣服等',"
				+ "6,"
				+ "'提供午餐',"
				+ "'山东大学齐鲁软件学院',"
				+"117.146703,"
				+"36.674967,"
				+"'2015.06.02',"
				+"'2015.10.01',"
				+"'15958147521',"
				+ "3,"
				+ "540,"
				+ "1,"
				+ "'image9',"
				+ "0,"
				+ "2);";

		listSql.add(insertSql);
		insertSql = "insert into NeedInfo (TitleName, TaskRequirement, Heavy, OtherWelfare, TaskAddress,TaskAddressLa,TaskAddressLo,BeginDate ,EndDate ,Telephone ,Stars, Charges, IsRealname, ImageName, start, end) "
				+ "values('浪潮集团', "
				+ "'15公里，爱心宣传，出席媒体活动，需提供照片。提供热水、洗浴、衣服等',"
				+ "6,"
				+ "'提供午餐',"
				+ "'济南市舜华路1500',"
				+"117.133803,"
				+"36.667586,"
				+"'2015.06.02',"
				+"'2015.10.01',"
				+"'15958147521',"
				+ "3,"
				+ "540,"
				+ "1,"
				+ "'image8',"
				+ "0,"
				+ "2);";
		listSql.add(insertSql);
		insertSql = "insert into NeedInfo (TitleName, TaskRequirement, Heavy, OtherWelfare, TaskAddress,TaskAddressLa,TaskAddressLo,BeginDate ,EndDate ,Telephone ,Stars, Charges, IsRealname, ImageName, start, end) "
				+ "values('济南长途汽车总站南区', "
				+ "'15公里，爱心宣传，出席媒体活动，需提供照片。提供热水、洗浴、衣服等',"
				+ "6,"
				+ "'提供午餐',"
				+ "'无影山中路2号',"
				+"116.999426,"
				+"36.690088,"
				+"'2015.06.02',"
				+"'2015.10.01',"
				+"'15958147521',"
				+ "3,"
				+ "540,"
				+ "1,"
				+ "'image10',"
				+ "0,"
				+ "2);";
		listSql.add(insertSql);
		insertSql = "insert into NeedInfo (TitleName, TaskRequirement, Heavy, OtherWelfare, TaskAddress,TaskAddressLa,TaskAddressLo,BeginDate ,EndDate ,Telephone ,Stars, Charges, IsRealname, ImageName, start, end) "
				+ "values('济南遥墙国际机场', "
				+ "'15公里，爱心宣传，出席媒体活动，需提供照片。提供热水、洗浴、衣服等',"
				+ "6,"
				+ "'提供午餐',"
				+ "'无影山中路2号',"
				+"117.217033,"
				+"36.856049,"
				+"'2015.06.02',"
				+"'2015.10.01',"
				+"'15958147521',"
				+ "3,"
				+ "540,"
				+ "1,"
				+ "'image7',"
				+ "0,"
				+ "2);";
		listSql.add(insertSql);
		insertSql = "insert into NeedInfo (TitleName, TaskRequirement, Heavy, OtherWelfare, TaskAddress,TaskAddressLa,TaskAddressLo,BeginDate ,EndDate ,Telephone ,Stars, Charges, IsRealname, ImageName, start, end,Introduce) "
				+ "values('火锅店面', "
				+ "'25公里广告宣传，城市沿街骑行',"
				+ "6,"
				+ "'提供热水、早晚饭、火锅餐券',"
				+ "'重庆市大坪区龙湖时代天街A馆L5',"
				+"106.517339,"
				+"29.544762,"
				+"'2015.07.08',"
				+"'2015.12.30',"
				+"'023-63851775',"
				+ "3,"
				+ "370,"
				+ "1,"
				+ "'image1',"
				+ "0,"
				+ "2,"
				+"'韩国年糕火锅，是一款生活中的美食、韩国风味菜谱。韩餐讲究“色、香、味、形、意、养”，十分注重科学饮食，和营养的合理搭配，一个“养”字把“药食同源”的理念点透，有着低脂肪、高营养的特点，以韩餐为根基。该店铺引领国内中小型餐饮的年轻风向，让消费者不出国门就能品尝正到宗韩餐，同时以汤底浓厚、纯香以及科学的营养搭配等优势得到各大新闻媒体的关注。推荐产品有济州海鲜锅、SUPER部队锅、米汁和炸鸡等。');";
		listSql.add(insertSql);
		insertSql ="insert into Comment (TaskID, OrderPos, ImageName, Content) values ("
				+"'12',"
				+"'1',"
				+"'head0',"
				+"'新开的店，骑行路线有点曲折，但风景不错，店里辣酱的口味中偏酸辣的那种，不是甜辣味。');";
		listSql.add(insertSql);
		insertSql ="insert into Comment (TaskID, OrderPos, ImageName, Content) values ("
				+"'12',"
				+"'2',"
				+"'head1',"
				+"'路过这里，骑了两次广告宣传，比想象中的好。');";
		listSql.add(insertSql);
		insertSql ="insert into Comment (TaskID, OrderPos, ImageName, Content) values ("
				+"'12',"
				+"'3',"
				+"'head2',"
				+"'骑车不累，宣传服很有特色。在这里吃了饭，米汁像醪糟水，淡淡的清香，总体来说还是值得推荐的！');";
		listSql.add(insertSql);
		insertSql ="insert into Comment (TaskID, OrderPos, ImageName, Content) values ("
				+"'12',"
				+"'4',"
				+"'head3',"
				+"'住了一晚，环境很好，下次还会来这里。');";
		listSql.add(insertSql);
		insertSql ="insert into Comment (TaskID, OrderPos, ImageName, Content) values ("
				+"'12',"
				+"'5',"
				+"'head4',"
				+"'刚刚休息下来，老板很热情，菜品很新鲜，服务好，第四次来这家店了。');";
		listSql.add(insertSql);
		insertSql ="insert into Comment (TaskID, OrderPos, ImageName, Content) values ("
				+"'12',"
				+"'6',"
				+"'head5',"
				+"'25公里真的很远，不过很值得，休息环境很舒服。');";
		listSql.add(insertSql);
		insertSql ="insert into Comment (TaskID, OrderPos, ImageName, Content) values ("
				+"'12',"
				+"'7',"
				+"'head4',"
				+"'走的时候老板送了瓶水和零食，很赞的店。');";
		listSql.add(insertSql);
		
		insertSql = "insert into NeedInfo (TitleName, TaskRequirement, Heavy, OtherWelfare, TaskAddress,TaskAddressLa,TaskAddressLo,BeginDate ,EndDate ,Telephone ,Stars, Charges, IsRealname, ImageName, start, end, Introduce) "
				+ "values('主题清酒吧', "
				+ "'25公里广告宣传，城市沿街骑行',"
				+ "6,"
				+ "'提供住宿、早中晚自助餐、热水公共卫生间、隔音',"
				+ "'湖北省武汉市汉阳区经济开发区',"
				+"114.208757,"
				+"30.553217,"
				+"'2015.08.20',"
				+"'2015.09.10',"
				+"'15926916737',"
				+ "3,"
				+ "688,"
				+ "1,"
				+ "'image2',"
				+ "0,"
				+ "2,"
				+"'该主题清酒吧是一个娱乐和饮酒结合的休闲场所，对外提供住宿、餐饮等服务，全店共有两层楼，一层主要经营酒水、唱歌、桌游等娱乐服务，二楼主要经营住宿、餐饮提供服务，消费人群为年轻单身群体。');";
		listSql.add(insertSql);
		insertSql ="insert into Comment (TaskID, OrderPos, ImageName, Content) values ("
				+"'13',"
				+"'1',"
				+"'head0',"
				+"'晚间城市很美，一点也不累，很喜欢这里的环境来。喜欢这家的东西，服务很棒。');";
		listSql.add(insertSql);
		insertSql ="insert into Comment (TaskID, OrderPos, ImageName, Content) values ("
				+"'13',"
				+"'2',"
				+"'head1',"
				+"'酒吧位置有点偏，在大厦的侧门那里，不是很好找到。');";
		listSql.add(insertSql);
		insertSql ="insert into Comment (TaskID, OrderPos, ImageName, Content) values ("
				+"'13',"
				+"'3',"
				+"'head2',"
				+"'超出想象，任务相对很少的了。啤酒种类很多，老板娘特好说话，还会再去的。');";
		listSql.add(insertSql);
		
		insertSql = "insert into NeedInfo (TitleName, TaskRequirement, Heavy, OtherWelfare, TaskAddress,TaskAddressLa,TaskAddressLo,BeginDate ,EndDate ,Telephone ,Stars, Charges, IsRealname, ImageName, start, end, Introduce) "
				+ "values('足球俱乐部', "
				+ "'提前一周报名，携带两名以上好友',"
				+ "6,"
				+ "'提供平板电脑、洗漱用具、热水器、早中晚餐',"
				+ "'重庆市江北区杨河二村3号',"
				+"106.538855,"
				+"29.590383,"
				+"'2015.05.06',"
				+"'2015.05.07',"
				+"'15045621992',"
				+ "3,"
				+ "450,"
				+ "1,"
				+ "'image2',"
				+ "0,"
				+ "0,"
				+"'重庆力帆足球俱乐部前身是成立于1994年的前卫武汉足球俱乐部。2015年1月28日，重庆市工商局江北分局发出撤销登记决定书，股东为重庆力帆控股有限公司，足协证实，重庆力帆已经具备征战2015年中超联赛的资格。其建设场地位于高新区，是大型城市基础设施项目之一。');";
		listSql.add(insertSql);
		insertSql ="insert into Comment (TaskID, OrderPos, ImageName, Content) values ("
				+"'14',"
				+"'1',"
				+"'head0',"
				+"'俱乐部装修很好，带了三个朋友来，晚上还能看球，玩的很嗨。');";
		listSql.add(insertSql);
		insertSql ="insert into Comment (TaskID, OrderPos, ImageName, Content) values ("
				+"'14',"
				+"'2',"
				+"'head1',"
				+"'活动只有一天，很巧骑到这里就赶上了，很幸运。');";
		listSql.add(insertSql);
		insertSql ="insert into Comment (TaskID, OrderPos, ImageName, Content) values ("
				+"'14',"
				+"'3',"
				+"'head2',"
				+"'供水供饭，环境是足球主题，各种国家的足球队。');";
		listSql.add(insertSql);
		insertSql ="insert into Comment (TaskID, OrderPos, ImageName, Content) values ("
				+"'14',"
				+"'4',"
				+"'head3',"
				+"'以后多搞这样的活动，会常来。');";
		listSql.add(insertSql);
		
		insertSql = "insert into NeedInfo (TitleName, TaskRequirement, Heavy, OtherWelfare, TaskAddress,TaskAddressLa,TaskAddressLo,BeginDate ,EndDate ,Telephone ,Stars, Charges, IsRealname, ImageName, start, end, Introduce) "
				+ "values('婚纱影楼', "
				+ "'骑行20公里',"
				+ "6,"
				+ "'提供住宿、双人间，免费送一套350元写真，限前99人',"
				+ "'广州越秀区中山三路平里4号',"
				+"113.26365,"
				+"23.163449,"
				+"'2015.05.09',"
				+"'2015.10.30',"
				+"'020-84638940',"
				+ "5,"
				+ "520,"
				+ "1,"
				+ "'image3',"
				+ "2,"
				+ "4,"
				+"'该店是全数码婚纱影楼，具有油画特色和浪漫唯美的两种摄影风格，室内拍摄场所包括10个场景摄影棚、VIP贵宾礼服区、化妆区、温馨贵宾休息区以及外景拍摄区，专用摄影师12名、专业化妆师20名、专业数码设计师21名及30名服务员。');";
		listSql.add(insertSql);
		insertSql ="insert into Comment (TaskID, OrderPos, ImageName, Content) values ("
				+"'15',"
				+"'1',"
				+"'head0',"
				+"'回来休息的时候发现这是个秀恩爱的场所，单身狗怎么办，唉。');";
		listSql.add(insertSql);
		insertSql ="insert into Comment (TaskID, OrderPos, ImageName, Content) values ("
				+"'15',"
				+"'2',"
				+"'head1',"
				+"'终于到了，有点累，都是一对对的，太幸福啦。');";
		listSql.add(insertSql);
		insertSql ="insert into Comment (TaskID, OrderPos, ImageName, Content) values ("
				+"'15',"
				+"'3',"
				+"'head2',"
				+"'我是七夕节来的，人很多呢，摄影师技术赞，拍的美美的，美女帅哥也很多~。');";
		listSql.add(insertSql);
		
		insertSql = "insert into NeedInfo (TitleName, TaskRequirement, Heavy, OtherWelfare, TaskAddress,TaskAddressLa,TaskAddressLo,BeginDate ,EndDate ,Telephone ,Stars, Charges, IsRealname, ImageName, start, end, Introduce) "
				+ "values('儿童家具城', "
				+ "'骑行10-15公里，角色扮演与宝宝加入游戏',"
				+ "6,"
				+ "'提供休息，自助饮料，儿童套餐加玩具',"
				+ "'广州市天河区天河北路28-32号',"
				+"113.323619,"
				+"23.146469,"
				+"'2015.06.01',"
				+"'2015.06.20',"
				+"'020-34284237',"
				+ "5,"
				+ "465,"
				+ "1,"
				+ "'image4',"
				+ "2,"
				+ "7,"
				+"'店铺介绍：拥有红木家具、实木家具、家居套房，对于儿童套房的家具，只使用清漆的家具更安全，现代板式家具的儿童卧房也都用水性漆来做涂料。为了让宝宝们在健康的环境下成长，我们会选择实木例如松木制成的家具，同时也提高了环保水平。');";
		listSql.add(insertSql);
		insertSql ="insert into Comment (TaskID, OrderPos, ImageName, Content) values ("
				+"'16',"
				+"'1',"
				+"'head0',"
				+"'这里有很多娱乐设施，看起来很高档，今天儿童节，可热闹了。');";
		listSql.add(insertSql);
		insertSql ="insert into Comment (TaskID, OrderPos, ImageName, Content) values ("
				+"'16',"
				+"'2',"
				+"'head1',"
				+"'那个智高拼图就能让两个小姑娘玩一上午，住这里都可以。');";
		listSql.add(insertSql);
		insertSql ="insert into Comment (TaskID, OrderPos, ImageName, Content) values ("
				+"'16',"
				+"'3',"
				+"'head2',"
				+"'今天第一次扮演超人，圆了儿时的梦啊哈哈，大超人和小超人。');";
		listSql.add(insertSql);
		
		insertSql = "insert into NeedInfo (TitleName, TaskRequirement, Heavy, OtherWelfare, TaskAddress,TaskAddressLa,TaskAddressLo,BeginDate ,EndDate ,Telephone ,Stars, Charges, IsRealname, ImageName, start, end, Introduce) "
				+ "values('自行车店铺', "
				+ "'7天移动广告骑行',"
				+ "6,"
				+ "'提供床铺，热饮，1500米无线网络，早饭，自行车免费修补，组队有惊喜',"
				+ "'青岛市李沧区金水路1046-20号',"
				+"120.429971,"
				+"36.181755,"
				+"'2015.08.20',"
				+"'2015.12.30',"
				+"'020-34284237',"
				+ "5,"
				+ "370,"
				+ "1,"
				+ "'image5',"
				+ "0,"
				+ "0,"
				+"'店铺介绍：该自行车店铺的销售区域面积140平米，产品从童车到通勤车、从山地车到公路车、从折叠车到小径车一应俱全，另外各式骑行装备应有尽有。它是青岛市体育局制定的全民健身中心，总占地面积一万多平米，云集了世界知名的运动品牌。');";
		listSql.add(insertSql);
		insertSql ="insert into Comment (TaskID, OrderPos, ImageName, Content) values ("
				+"'17',"
				+"'1',"
				+"'head0',"
				+"'休息了一小会，上网的时间，车子很快就就修好了，效率高！');";
		listSql.add(insertSql);
		insertSql ="insert into Comment (TaskID, OrderPos, ImageName, Content) values ("
				+"'17',"
				+"'2',"
				+"'head1',"
				+"'感觉像短期旅行，住了很久，服务人员很多，热情周到。');";
		listSql.add(insertSql);
		insertSql ="insert into Comment (TaskID, OrderPos, ImageName, Content) values ("
				+"'17',"
				+"'3',"
				+"'head2',"
				+"'我们四个人一起来的，任务不多条件待遇很好，老板赠送了些新配件。');";
		listSql.add(insertSql);
		insertSql ="insert into Comment (TaskID, OrderPos, ImageName, Content) values ("
				+"'17',"
				+"'4',"
				+"'head3',"
				+"'7天有点累，建议女孩子不要尝试。');";
		listSql.add(insertSql);
		insertSql ="insert into Comment (TaskID, OrderPos, ImageName, Content) values ("
				+"'17',"
				+"'5',"
				+"'head4',"
				+"'看到广告就来了，没想到遇到好多旅友呢，感觉很棒！');";
		listSql.add(insertSql);
		
		insertSql = "insert into NeedInfo (TitleName, TaskRequirement, Heavy, OtherWelfare, TaskAddress,TaskAddressLa,TaskAddressLo,BeginDate ,EndDate ,Telephone ,Stars, Charges, IsRealname, ImageName, start, end, Introduce) "
				+ "values('理发城', "
				+ "'骑行15公里，身着广告服骑单车宣传',"
				+ "6,"
				+ "'提供休息室，咖啡，早饭，健身房、免费理发',"
				+ "'青岛市李沧区金水路1046-20号',"
				+"120.429971,"
				+"36.181755,"
				+"'2015.08.10',"
				+"'2015.09.30',"
				+"'020-34284237',"
				+ "5,"
				+ "300,"
				+ "1,"
				+ "'image5',"
				+ "2,"
				+ "4,"
				+"'骑行距离增加可另谈');";
		listSql.add(insertSql);
		insertSql ="insert into Comment (TaskID, OrderPos, ImageName, Content) values ("
				+"'18',"
				+"'1',"
				+"'head0',"
				+"'骑行的距离不多，但广告服有点夸张，然后有免费理发和健身房，健身房有点小，但机器性能挺好的。');";
		listSql.add(insertSql);
		insertSql ="insert into Comment (TaskID, OrderPos, ImageName, Content) values ("
				+"'18',"
				+"'2',"
				+"'head1',"
				+"'宣传单有点太多了，不过福利很好，休息室有美女。');";
		listSql.add(insertSql);
		insertSql ="insert into Comment (TaskID, OrderPos, ImageName, Content) values ("
				+"'18',"
				+"'3',"
				+"'head2',"
				+"'咖啡不错，喝了骑车很有精神。');";
		listSql.add(insertSql);
		return listSql;
	}
}
