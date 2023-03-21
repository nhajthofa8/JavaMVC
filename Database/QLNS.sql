CREATE DATABASE QLNS
USE QLNS

-- TẠO BẢNG
create table admin (
	id int IDENTITY(1,1) PRIMARY KEY,
	username nvarchar(50) UNIQUE not null,
	password nvarchar(50) not null,
	name nvarchar(50) not null
)

insert into admin values ('admin', '123456', N'Nguyễn Hùng')

create table users (
	id int IDENTITY(1,1) PRIMARY KEY,
	name nvarchar(50) not null,
	email nvarchar(50) UNIQUE not null,
	phone nvarchar(20) not null,
	username nvarchar(50) UNIQUE not null,
	password nvarchar(50) not null,
	created date not null
)


create table catalog
(
	id int IDENTITY(1,1) PRIMARY KEY,
	name nvarchar(50) not null,
	parent_id int null
)


Create table product (
	id int IDENTITY(1,1) PRIMARY KEY,
	catalog_id int not null foreign key references catalog(id) on delete cascade,
	name nvarchar(50) not null,
	price nvarchar(20) not null,
	status int not null,
	description nvarchar(4000) not null,
	content nvarchar(4000) not null,
	discount int,
	image_link nvarchar(4000) not null,
	created date not null,  
)


create table review 
(
	id int IDENTITY(1,1) primary key,
	product_id int not null foreign key references product(id) on delete cascade,
	name nvarchar(50) not null,
	email nvarchar(50) not null,
	content nvarchar(4000) not null,
	created date ,
)


create table transactions
(
	id int IDENTITY(1,1) primary key,
	user_session nvarchar(50) not null,
	user_name nvarchar(50) not null,
	user_mail nvarchar(50) not null,
	user_phone nvarchar(20) not null,
	address nvarchar(300) not null,
	message nvarchar(4000) not null,
	amount nvarchar(20) not null,
	payment nvarchar(30) not null,
	status nvarchar(30),
	created date not null
);


create table ordered
(
	id int IDENTITY(1,1) primary key,
	product_id int not null foreign key references product(id) on delete cascade,
	transaction_id int not null foreign key references transactions(id) on delete cascade,
	qty int not null,	
);


create table boardnew
(
	id int IDENTITY(1,1) primary key,
	title nvarchar(200) not null,
	content nvarchar(4000) not null,
	image_link nvarchar(4000) not null,
	author nvarchar(50) not null,
	created date not null,
);


INSERT INTO catalog(name,parent_id) 
	VALUES (N'Quạt - Máy Làm Mát',null);
INSERT INTO catalog(name,parent_id) 
	VALUES (N'Máy Pha Cà Phê',null);
INSERT INTO catalog(name,parent_id) 
	VALUES (N'Máy Hút Bụi',null);
INSERT INTO catalog(name,parent_id) 
	VALUES (N'Đồ Dùng Nhà Bếp',null);
INSERT INTO catalog(name,parent_id) 
	VALUES (N'Sản Phẩm Mới',null);
INSERT INTO catalog(name,parent_id) 
	VALUES (N'Sản Phẩm Bán Chạy',null)
INSERT INTO catalog(name,parent_id) 
	VALUES (N'Sản Phẩm Giảm Giá',null);
	INSERT INTO catalog(name,parent_id) 
	VALUES (N'Hộp Cơm Giữ Nhiệt',null);
INSERT INTO catalog(name,parent_id) 
	VALUES (N'Máy Lọc Nước',null);
INSERT INTO catalog(name,parent_id) 
	VALUES (N'Các Loại Bếp',null);
INSERT INTO catalog(name,parent_id) 
	VALUES (N'Lò Nướng - Bếp Nướng',null);
	INSERT INTO catalog(name,parent_id) 
	VALUES (N'Bàn Là - Bàn Ủi',null);
INSERT INTO catalog(name,parent_id) 
	VALUES (N'Bình Thủy - Phích Nước',null);

insert into product values (1,N'Quạt đứng Senko','690.000','1',N'Quạt cây gia đình',N'Gia đình bạn có quá đông người mà một chiếc quạt bé sẽ không thể đáp ứng đủ nhu cầu trong mùa hè nóng nực? Với quạt đứng Senko có điều khiển từ xa DR1608 được trang bị tới 7 cánh quạt mang đến luồng gió mạnh, có thể sử dụng trong không gian rộng, nhu cầu làm mát của gia đình bạn sẽ được giải quyết thật nhanh chóng, dễ dàng!',4,'quat-dung-senko.jpg','2021-05-30')
insert into product values (1,N'Quạt tháp','750.000','1',N'Quạt cây có điều khiển',N'Quạt tháp có hình trụ đứng, không sử dụng cánh quạt như các loại quạt truyền thống mà sử dụng cánh quạt lồng tương tự như trong máy lạnh, do vậy có độ bền vô cùng cao và an toàn khi sử dụng. ',10,'quat_thap.jpg','2021-05-30')
insert into product values (1,N'Quạt công nghiệp','890.000','1',N'Quạt gắn tường công nghiệp',N'Quạt treo tường công nghiệp giải pháp làm mát không gian rộng mà không tốn nhiều diện tích. Quạt công nghiệp treo tường NB 65 Plus tạo gió thông minh, tiện lợi cho các quán ăn, nhà xưởng, đám tiệc, sự kiện… Quạt công nghiệp Ifan sử dụng động cơ lõi dây đồng 100% cho hiệu quả làm việc cao hơn nhiều so với động cơ dây nhôm. Việc sử dụng động cơ dây đồng giúp quạt chạy khỏe, tạo gió mạnh, ít gây ồn hay hỏng hóc.',10,'quat-cong-nghiep.jpg','2021-05-30')
insert into product values (1,N'Quạt trần Panasonic','390.000','1',N'Quạt trần tích hợp tính năng hẹn giờ',N'Quạt trần Panasonic 5 cánh F-60WWK được sản xuất trên dây chuyền công nghệ của Nhật Bản, đáp ứng được đầy đủ các tiêu chuẩn khắt khe nhất về kỹ thuật, độ an toàn và tính tiết kiệm điện. Mô tơ của quạt rất bền và chạy êm, 5 cánh được làm từ vật liệu đặc biệt không cong vênh, đảm bảo không phải cân chỉnh trong suốt quá trình sử dụng, tháo lắp bảo dưỡng sau này.',34,'quat-tran.jpg','2021-05-30')
insert into product values (1,N'Máy lạnh di động ','300.000','1',N'Máy lạnh thông minh',N'Máy lạnh di động Casper sử dụng dàn tản nhiệt đồng mạ vàng siêu bền bỉ cho hiệu suất làm lạnh cao và tăng khả năng chống mài mòn, hoạt động tốt trong nhiều điều kiện thời tiết khác nhau.',10,'may-lanh-di-dong.jpg','2021-05-30')
insert into product values (1,N'Quạt hơi nước Magic','445.000','1',N'Máy làm mát 20m2 - 30m2',N'Quạt điều hòa Magic A48 (Magic A45) được trang bị chức năng làm lạnh bằng hơi nước. Chức năng này sẽ hoạt động theo nguyên lý hút không khí nóng trong phòng vào trong máy, sau đó không khí nóng sẽ được hấp thụ qua tấm làm mát giúp thổi ra luồng khí lạnh mát mẻ, dễ chịu hơn.',10,'quat-hoi-nuoc-magic.jpg','2021-05-30')
insert into product values (1,N'Quạt hút âm trần','580.000','1',N'Quạt hút mùi, hút khói âm trần',N'Quạt hút mùi, thông gió là giải pháp hiệu quả giúp lưu thông không khí giữa bên trong nhà ra ngoài trời, quạt thường được lắp tại nhà bếp hay nhà tắm, nhà vệ sinh giúp không gian được thông thoáng, sạch. Sản phẩm quạt hút âm trần Mitsubishi EX-15SCT thiết kế nhỏ gọn, được lắp đặt âm trần là 1 trong các sản phẩm như vậy.',10,'quat-hut-am-tran.jpg','2021-05-30')
insert into product values (1,N'Quạt đảo trần','699.000','1',N'Quạt đảo trần 360 độ',N'Asia X16002 là mẫu quạt đảo trần được nhiều gia đình lựa chọn lắp đặt nhất hiện nay. Quạt đảo trần Asia X16002 được lắp đặt trên cao, quay với hướng 360 độ giúp lan tỏa làn gió mát đồng đều khắp không gian phòng cho bạn cảm giác mát mẻ, thư giãn.',0,'quat-dao-tran.jpg','2021-05-30')
insert into product values (1,N'Quạt tích điện mini','230.000','1',N'Quạt tích điện để bàn',N'Mocato Air M503 sử dụng pin sạc Polymer với dung lượng 3200 mAh cho phép hoạt động liên tục 16 giờ chỉ với một lần sạc, giúp bạn thoải mái tận hưởng luồng không khí mát ở bất kỳ nơi đâu.',10,'quat-tich-dien-mini.jpg','2021-05-30')

insert into product values (2,N'Máy pha cà phê','870.000','1',N'Máy pha cà phê tự động',N'Máy pha cà phê Delonghi ECAM 22.110B là dòng máy pha cà phê tự động nhỏ gọn nhất của thương hiệu Delonghi, nhưng không vì thế mà máy mất đi các tính năng cần thiết cũng như chất lượng cà phê espresso theo tiêu chuẩn Ý. Công việc vệ sinh, cũng như vận hành vô cùng dễ dàng với các nút nhấn thân thiện với người dùng, có thể lập trình được cho những lượng cà phê khác nhau phù hợp với sở thích của các khách hàng khác nhau.',20,'may-pha-ca-phe-delonghi.jpg','2021-05-30')
insert into product values (2,N'Máy pha cà phê Nuova','950.000','1',N'Máy pha cà phê chuyên nghiệp',N'Máy pha cà phê Nuova Simonelli Appia II Volumetric 2 group có công suất phục vụ 200 ly/h, đáp ứng được nhu cầu sử dụng của quán cà phê, nhà hàng, khách sạn. Đây là loại máy pha cà phê chuyên nghiệp, có định lượng bằng thể tích để luôn đảm bảo chất lượng cà phê ngon nhất.',15,'Nuova-Simonelli-Appia.jpg','2021-05-30')
insert into product values (2,N'Máy pha cà phê viên nén','290.000','1',N'Máy pha cà phê gia đình',N'Máy pha cà phê viên nén Hafele HE-BMM018 là một giải pháp hữu ích cho những công ty hay văn phòng làm việc với chi phí đầu tư ban đầu không quá cao nhưng vẫn đem lại được ly cà phê chất lượng. Máy được sản xuất và kiểm duyệt kĩ lưỡng từ Đức, sẽ mang đến cho bạn nhiều tính năng tiện dụng cũng như giúp thời gian pha cà phê nhanh chóng hơn.',0,'may-pha-ca-phe-vien-nen.jpg','2021-05-30')
insert into product values (2,N'Ấm pha cà phê','920.000','1',N'Bình pha cà phê',N'Ấm pha cà phê Bialetti BCM-1718 được thiết kế dành cho những người yêu thích hương vị đậm đà của cà phê cũng như đam mê nét đẹp lãng mạn đầy phong cách Ý.Thiết kế sang trọng nổi bật tạo bởi chất liệu inox sáng bóng, tay cầm và núm nắp bật cách điệu mang đến cho chiếc ấm cái nhìn đầy mê hoặc, hấp dẫn như chính vị cà phê thơm nóng hổi mà nó tạo ra.',10,'am-pha-ca-phe-bialetti.jpg','2021-05-30')
insert into product values (2,N'Cối xay cà phê','968.000','1',N'Cối xay cà phê quay tay',N'Ly cà phê thơm ngon hay không yếu tố quan trọng nhất là cà phê. Tự tay chuẩn bị những hạt cà phê thơm ngon, chất lượng và tự xay nhuyễn nó bạn sẽ có những ly cà phê đúng theo sở thích.',10,'coi-xay-ca-phe.jpg','2021-05-30')

insert into product values (3,N'Máy hút bụi dùng pin ','950.000','1',N'Máy hút bụi cầm tay mini',N'Máy hút bụi dùng pin 18V Bosch GAS 18V-1 SET là sự lựa chọn lý tưởng cho nhiều đối tượng khách hàng với nhiều mục đích khác nhau, như công việc quét dọn vệ sinh nhà cửa hay vệ sinh mùn cưa sau khi xây dựng,... Đây là sản phẩm máy hút bụi mini dùng pin 18V sẽ tối giản thời gian và công sức lao công của mọi người.',10,'may-hut-bui-dung-pin.jpg','2021-05-30')
insert into product values (3,N'Máy lau sàn 2 trong 1','800.000','1',N'Máy lau sàn',N'Lau sàn không cần hút bụi trước chỉ trong 1 bước duy nhất',10,'may-lau-san-2-trong-1.jpg','2021-05-30')
insert into product values (3,N'Robot hút bụi','190.000','1',N'Robot hút bụi thông minh',N'Robot hút bụi lau nhà Medion MD19510 có thiết kế hiện đại, kiểu dáng gọn gàng với trọng lượng chỉ 2.05kg, giúp bạn di chuyển thiết bị đến nhiều vị trí khác nhau một cách dễ dàng.',0,'robot-hut-bui.jpg','2021-05-30')
insert into product values (3,N'Robot lau kính','750.000','1',N'Robot lau kính thông minh',N'HOBOT-388 gần giống như robot hút bụi lau nhà nhưng nó có chức năng là robot lau kính, nằm trong top sản phẩm được tin dùng nhất trên toàn thế giới, là lựa chọn bạn không nên bỏ qua khi có thắc mắc nên mua robot lau kính loại nào tốt. Sản phẩm có thiết kế thời trang và nhỏ gọn, làm sạch nhanh và hiệu quả tất cả các bề mặt kính, kể cả những nơi mà con người không thể làm được như kính ngoài trời.',10,'robot-lau-kinh-hobot-388.jpg','2021-05-30')

insert into product values (4,N'Chảo inox cao cấp','520.000','1',N'Chảo bếp từ',N'Chảo chống dính Elmich Tri-Max 2353739 có đường kính 26cm lý tưởng để chiên rán thực phẩm cho gia đình. Chảo inox cao 11cm có cán chảo được tán đinh chắc chắn, cách nhiệt không gây nóng, bỏng tay khi đun nấu.',0,'chao-inox-cao-cap.jpg','2021-05-30')
insert into product values (4,N'Bình thủy điện','155.000','1',N'Phích thủy điện',N'Bình thủy điện giúp giữ và duy trì nước nóng ở nhiệt độ 98 độ C. Phích giữ nhiệt Nagakawa NAG0405 có khả năng tự đun sôi lại nếu nước ở dưới mức nhiệt tối đa.',10,'binh-thuy-dien.jpg','2021-05-30')
insert into product values (4,N'Ấm đun nước inox 304','649.000','1',N'Bình đun nước trên bếp',N'Đây là một trong những loại ấm đun nước được ưa chuộng sử dụng bởi tính năng tiện lợi. Ấm có khả năng đun nóng nước nhanh chóng và tiện lợi. Ấm đun nước Elmich được làm bằng chất liệu cao cấp inox 304 có độ bóng cao, tuyệt đối an toàn cho sức khỏe lại vừa dễ lau chùi và làm sạch. ',0,'am-dun-nuoc-inox-304.jpg','2021-05-30')
insert into product values (4,N'Nồi điện đa năng','550.000','1',N'Nồi điện đa chức năng',N'Nồi điện đa năng Ariranglife AL-D12L5 có thiết kế nhỏ gọn, rất tiện dụng để nấu mỳ, nấu lẩu, luộc trứng,... thích hợp với học sinh, sinh viên và các hộ gia đình nhỏ.',10,'noi-dien-da-nang.jpg','2021-05-30')
insert into product values (4,N'Bình nước cầm tay','140.000','1',N'Bình đựng nước',N'Rạng Đông RD-05P1 là mẫu bình đựng nước cầm tay rất được ưa chuộng, hàng Việt Nam chất lượng cao. Bình nước sở hữu nhiều màu sắc: Màu tím, vàng chanh, xanh ngọc, xanh lá cây. ',10,'binh-nuoc-cam-tay.jpg','2021-05-30')
insert into product values (4,N'Máy hút mùi than hoạt tính','650.000','1',N'Máy hút mùi nhà bếp có bộ lọc than hoạt tính',N'Máy hút mùi Nagakawa NAG1803-70T thiết kế kiểu dáng hiện đại với gam màu đen đẹp mắt. Kích thước máy là 700 x 135 x 480 mm sẽ dễ dàng lắp đặt ở mọi không gian bếp. ',10,'may-hut-mui.jpg','2021-05-30')
insert into product values (4,N'Lò vi sóng Sharp','350.000','1',N'Lò vi sóng cơ',N'Lò vi sóng Sharp thiết kế đơn giản nhưng không kém phần sang trọng mang lại sự hiện đại cho không gian bếp nhà bạn. Lò vi sóng có chất liệu thép không gỉ sơn tĩnh điện bền bỉ, dễ dàng vệ sinh.',10,'lo-vi-song-sharp.jpg','2021-05-30')
insert into product values (4,N'Bình đun nước pha sữa','850.000','1',N'Bình đun nước đa năng',N'Ấm đun nước pha sữa Bonbébé BB-06 có thể tùy chỉnh nhiệt độ phù hợp với nhu cầu sử dụng như: hâm sữa mẹ, đun nước pha sữa, pha cafe, ngâm trà, giữ ấm… Công nghệ điều chỉnh nhiệt độ tùy chọn lên đến 100 độ C bằng cảm ứng linh hoạt, thao tác đơn giản dễ dùng.',10,'binh-dun-nuoc-pha-sua.jpg','2021-05-30')
insert into product values (4,N'Thùng đựng gạo thông minh','319.000','1',N'Thùng đựng gạo gia đình',N'Thùng đựng gạo thông minh Tashuan TS 3626A được làm từ chất liệu nhựa PP, đảm bảo an toàn cho sức khỏe người dùng, với sức chứa lớn lên đến 16kg nhưng trọng lượng thùng siêu nhẹ chỉ có 1,8 kg rất dễ dàng để người dùng di chuyển và lắp đặt thùng khi sử dụng.',0,'thunggao-1.jpg','2021-05-30')

insert into product values (5,N'Bộ dao inox Elmich 6 món','290.000','1',N'Bộ dao làm bếp',N'Một bộ dao tốt sẽ giúp các chị em nội trợ dễ dàng hơn trong việc nấu nướng, để thể hiện các món ăn yêu thích một các nhẹ nhàng hơn. Bộ dao inox Elmich 6 món EL3801 bao gồm 4 dao, 1 kéo, 1 giá để dao sẽ là "cánh tay phải" đắc lực, giúp bạn rút ngắn thời gian nấu ăn và có thể chế biến nhiều món ăn hơn cho gia đình.',0,'bo-dao-inox-elmich-6-mon.jpg','2021-05-30')
insert into product values (5,N'Thớt chữ nhật Cata inox 304','389.000','1',N'Thớt inox hình chữ nhật',N'Thớt Cata sử dụng chất liệu inox 304 bền bỉ, sạch sẽ, không bị cong vênh hay biến dạng',10,'thot-chu-nhat-cata-inox.jpg','2021-05-30')
insert into product values (5,N'Bát trộn thực phẩm','155.000','1',N'Bát nhựa nguyên sinh 2.200ml',N'Thân bát trộn thực phẩm KB-MI2200S1 sử dụng chất liệu nhựa SAN, vành bát dùng nhựa ABS cứng cáp, không chứa chất gây ung thư BPA, độ bền cao, kháng hóa chất và an toàn với sức khỏe.',0,'bat-tron-thuc-pham.jpg','2021-05-30')
insert into product values (5,N'Máy lọc nước Unilever Pureit Ultima','990.000','1',N'Máy lọc nước gia đình',N'Máy lọc nước Unilever Pureit Ultima RO + UV được các tổ chức uy tín trên thế giới khuyên dùng, có thiết kế nhỏ gọn có thể treo tường hoặc để trên kệ, phù hợp với không gian sang trọng hiện đại. Máy dùng điện, với 7 bước lọc, lọc sạch tạp chất, vi khuẩn, sắt và chì.',10,'may-loc-nuoc-unilever-pureit-ultima.jpg','2021-05-30')
insert into product values (5,N'Bàn là Panasonic','350.000','1',N'Bàn ủi khô',N'Bàn là Panasonic PABU-NI-317T với thiết kế tiện lợi, gọn nhẹ, có thể ủi được các loại vải. Bạn có thể điều chỉnh nhiệt độ ủi thích hợp cho từng loại vải bằng núm điều chỉnh nhiệt (được thiết kế trên thân bàn ủi), giúp công việc là ủi trở nên chính xác và an toàn hơn. Bàn là nhỏ gọn giúp bạn dễ dàng mang theo khi xa.',10,'ban-la-panasonic-pabu.jpg','2021-05-30')
insert into product values (5,N'Bình giữ nhiệt Elmich inox 304','369.000','1',N'Bình giữ nhiệt nóng lạnh',N'Bình giữ nhiệt Elmich inox 304 K10 2246388 sẽ giúp bạn có thể đem theo đồ uống ưa thích của mình mọi nơi mà vẫn luôn giữ nguyên nhiệt độ và hương vị. Phần nắp đậy có gioăng bằng silicon giúp giữ kín hơi, không để nước tràn ra bên ngoài, thuận tiện cho việc giữ nóng và giữ lạnh nước uống, không lo rò rỉ nước khi di chuyển.',10,'binh-giu-nhiet-elmich-inox-304.jpg','2021-05-30')
insert into product values (5,N'ồi chiên không dầu xoay 360 độ','790.000','1',N'Nồi chiên không khí',N'Khác với những nồi chiên không khí trước đây, nồi chiên không dầu Nagakawa NAG3302 sở hữu thiết kế độc đáo, như 1 chiếc lò nướng thủy tinh. 2 núm vặn giúp dễ dàng tùy chỉnh thời gian và nhiệt độ nấu nướng cùng lớp kính trong suốt cho người đầu bếp dễ dàng quan sát thực phẩm bên trong.',10,'noi-chien-khong-dau-xoay-360-do.jpg','2021-05-30')

insert into product values (6,N'Hộp bảo quản thực phẩm','100.000','1',N'Hộp nhựa bảo quản thực phẩm',N'BioZone KB-CO440P được thiết kế hình hộp chữ nhật với dung tích 440ml, thích hợp bảo quản thực phẩm khô và thực phẩm ướt. Thân hộp và nắp hộp đều được làm từ nguyên liệu nhựa PP nguyên sinh, không chứa chất gây ung thư BPA, kháng hóa chất và an toàn với sức khỏe, phù hợp sử dụng cho mọi gia đình. ',20,'hop-bao-quan-thuc-pham.jpg','2021-05-30')
insert into product values (6,N'Lọ xay tiêu','199.000','1',N'Dụng cụ xay tiêu bằng tay',N'Lọ xay tiêu Elmich EL7156 có lưỡi nghiền được thiết kế độc đáo giúp bạn có thể xay, nghiền tiêu nhanh hơn, sắc bén và cho thời gian sử dụng lâu. Ngoài ra, người dùng cũng có thể dùng lọ xay tiêu để bảo quản hạt tiêu, giúp hạn chế ẩm mốc.',10,'lo-xay-tieu-elmich-el7156.jpg','2021-05-30')
insert into product values (6,N'Bộ dụng cụ nhà bếp Elmich 7 món','459.000','1',N'Bộ dụng cụ nhà bếp cao cấp',N'Bộ dụng cụ nhà bếp gồm 7 vật dụng hỗ trợ bạn hàng ngày trong việc nấu nướng. Bộ dụng cụ nhà bếp Elmich 7 món Eubase EL3853 (2323853) được làm từ chất liệu cao cấp, an toàn và bền đẹp không chỉ đem lại độ bền tốt mà còn rất an toàn cho sức khỏe cả gia đình. ',15,'bo-dung-cu-nha-bep-elmich-7-mo.jpg','2021-05-30')
insert into product values (6,N'Nồi chiên không dầu Rapido','200.000','1',N'Nồi chiên không khí',N'Rapido RAF-6.5D thiết kế màu đen tuyền sạch sẽ, lớp nhựa ABS ở vỏ nồi có khả năng cách nhiệt, chịu nhiệt và chống biến dạng, hạn chế bám bẩn. Kiểu dáng nồi gọn gàng với đường kính là 38cm, cao 33cm. Khay chiên làm bằng vật liệu nhôm đúc nguyên khối phủ chống dính ceramic bền, khó bong tróc và đặc biệt là rất an toàn cho sức khỏe. ',10,'noi-chien-khong-dau-rapido.jpg','2021-05-30')
insert into product values (6,N'Máy hút chân không và hàn miệng túi','249.000','1',N'Máy hút chân không tự động',N'Máy hàn miệng túi kiêm máy hút chân không Bluestone VSB-2735 sử dụng chất liệu bằng nhựa cao cấp và thép không gỉ cho độ bền chắc cao, ít bám bẩn, dễ làm sạch.',10,'may-hut-chan-khong-va-han-mieng-tui.jpg','2021-05-30')
insert into product values (6,N'Bộ lau nhà xoay 360 độ Sunhouse','390.000','1',N'Cây lau nhà có thùng vắt',N'Bộ lau nhà là vật dụng cần thiết cho mỗi gia đình, sản phẩm bao gồm cây lau và thùng vắt. Với bộ lau nhà Sunhouse KS-CL350PO công việc dọn dẹp nhà cửa của bạn sẽ trở nên dễ dàng, tiết kiệm sức lực hơn rất nhiều.',10,'bo-lau-nha-xoay-360-do-sunhouse.jpg','2021-05-30')
insert into product values (6,N'Máy vệ sinh hơi nước Ariete ','950.000','1',N'Thiết bị làm sạch bằng hơi nước',N'Máy vệ sinh hơi nước Ariete MOD 4147 là một thiết bị vệ sinh hiện đại. Máy ứng dụng sức mạnh hơi nước mang tới sự khác biệt trong việc làm sạch các đồ gia dụng, mặt sàn... trong gia đình.',10,'may-ve-sinh-hoi-nuoc-ariete.jpg','2021-05-30')
insert into product values (6,N'Lẩu điện Tiger Queen 2 trong 1','890.000','1',N'Nồi lẩu điện',N'Nồi lẩu điện Tiger Queen 2 trong 1 SQ-2200 gồm 2 lòng tráng men chống dính bằng tia hồng ngoại (lòng nồi chiên chống dính và lòng nồi lẩu chống dính) với 7 chức năng nấu (lẩu, nướng, rang, chiên, xào, hầm, luộc), nắp kính chịu nhiệt, tay cầm không nóng, 5 mức điều chỉnh nhiệt độ đến 250ºC phù hợp với từng loại nguyên liệu, nóng nhanh tiết kiệm thời gian, có chức năng ngắt nhiệt tự động để tiết kiệm điện, màu đen.',10,'lau-dien-tiger-queen-2-trong-1.jpg','2021-05-30')

insert into product values (7,N'Máy làm bắp rang tại nhà','249.000','1',N'Máy nổ bỏng ngô mini',N'Bắp rang là một món ăn ưa thích của rất nhiều người, có thể là đồ ăn vặt của các bé, món nhấm nháp khi ôm máy tính cày phim, món ăn vặt khi dỗi miệng. Chính vì lí do này mà nhà TEXET đã cho ra đời dóng máy làm bắp rang tại nhà TEXET PM-40 hay máy nổ bỏng ngô mini TEXET PM-40. Đặc biệt hơn, chiếc máy này còn có khả năng rang sấy các loạt hạt, vô cùng đa năng.',0,'may-lam-bap-rang.jpg','2021-05-30')
insert into product values (7,N'Nồi hấp thực phẩm đa năng','349.000','1',N'Nồi hấp điện gia đình',N'Magic Korea A64 là chiếc nồi hấp điện lý tưởng dành cho gia đình. Nồi hấp thực phẩm đa năng Magic A64 thiết kế có 2 tầng hấp, với tổng dung tích của nồi hấp là 5 lít, đáp ứng được nhu cầu sử dụng cho gia đình có từ 3 - 5 thành viên.',10,'noi-hap-thuc-pham-da-nang-magic.jpg','2021-05-30')
insert into product values (7,N'Cây lau nhà thông minh Saiko','650.000','1',N'Cây lau chữ nhật',N'Cây lau nhà Saiko MOP-Z10 được thiết kế thông minh với đầu lau hình chữ nhật tạo nên lực ly tâm lớn giúp bạn lau sạch những ngóc ngách phức tạp một cách nhẹ nhàng.',0,'cay-lau-nha-thong-minh-saiko.jpg','2021-05-30')
insert into product values (7,N'Máy lau sàn 2 trong 1 Karcher','800.000','1',N'Máy lau sàn',N'Công việc lau dọn luôn là nỗi ám ảnh đối với các chị em nội trợ. Đặc biệt là những gia đình nào có trẻ nhỏ, việc đổ sữa, cháo hay nước sốt ra sàn là rất thường xuyên. Thay vì phải dọn sạch thức ăn trên sàn sau đó lại lấy chổi lau hoặc giẻ để vệ sinh lại sàn nhà rất tốn thời gian và công sức thì nay bạn đã có thể vệ sinh mọi vết bẩn 1 cách đơn giản hơn với máy lau sàn 2 trong 1 Karcher FC 5.',30,'may-lau-san-2-trong-11.jpg','2021-05-30')
insert into product values (7,N'Lẩu điện Sunhouse','559.000','1',N'Nồi lẩu điện',N'Sunhouse SH 535L có dung tích 3.5 lít sẽ phù hợp sử dụng cho gia đình có từ 4 - 6 thành viên. Nồi lẩu điện Sunhouse có lòng nồi bằng hợp kim nhôm tráng men chống dính nên vừa có thể dùng để nấu lẩu, vừa có thể xào rau. ',15,'lau-dien-sunhouse.jpg','2021-05-30')
insert into product values (7,N'Bếp từ đôi Kangaroo','750.000','1',N'Bếp từ gia đình',N'Bếp điện từ đôi Kangaroo KG498N với thiết kế 2 trong 1: có thể đặt âm hoặc đặt dương trên mặt bàn. Mặt kính chịu nhiệt, chịu lực, dễ dàng vệ sinh lau chùi. An toàn tuyệt đối với hệ thống cảnh báo nồi nấu không phù hợp, tự động ngắt sau 120 phút, cảm biến nhiệt độ. ',26,'bep-tu-doi-kangaroo.jpg','2021-05-30')

insert into product values (8,N'Hộp cơm điện 3 tầng Magic','329.000','1',N'Hộp hâm cơm điện ruột inox',N'Hộp cơm điện 3 tầng Magic A06 được làm từ chất liệu inox 304 và nhựa PP, có 3 tầng được thiết kế nắp gài chắc chắn cùng nắp đậy cho từng ngăn đựng riêng biệt. Hộp cơm giữ nhiệt Magic A06 ngoài chức năng hâm nóng thực phẩm còn có thể nấu cơm, nấu xôi, chưng trứng thịt, nấu canh, làm bánh, luộc trứng, hấp thực phẩm, nấu súp...',8,'hop-ham-nau-com-magic.jpg','2021-05-30')
insert into product values (8,N'Hộp hâm nóng thức ăn ','399.000','1',N'Hộp cơm văn phòng 3 tầng',N'Hộp cơm hâm nóng đa năng Mishio MK-182 phù hợp nhu cầu sử dụng giữ ấm cơm cho nhân viên văn phòng, mang theo đồ ăn đi dã ngoại, người làm việc bên ngoài, thậm chí dùng để nấu cơm cho gia đình từ 1 - 2 người. Hộp hâm cơm thức ăn là loại nồi cơm mini có cắm điện phục vụ nhu cầu ăn nóng, ăn sạch nhưng gọn nhẹ của người tiêu dùng.',16,'hop-ham-nong-thuc-an-.jpg','2021-05-30')
insert into product values (8,N'Cặp lồng cơm giữ nhiệt','659.000','1',N'Hộp cơm giữ nhiệt',N'Elmich EL7284 là sản phẩm rất hữu ích đối với dân văn phòng, người lao động, học sinh. Cặp lồng cơm giữ nhiệt Elmich gồm 1 hộp lớn có dung tích 1.500ml, chứa được 3 hộp nhỏ sẽ mang đủ phần ăn cho một người.',10,'cap-long-com-giu-nhiet.jpg','2021-05-30')
insert into product values (8,N'Cà men cơm Apollo 3 ngăn','890.000','1',N'Hộp đựng cơm',N'Hộp cơm giữ nhiệt APL-1600 có tổng dung tích 1.45 lít, phục vụ lượng thức ăn cho 1 - 2 người. Với khả năng giữ nhiệt 64ºC trong 6 giờ, bạn sẽ luôn có bữa trưa ngon lành, ấm nóng dù chuẩn bị thức ăn từ sáng. Bên cạnh đó, bạn cũng có thể thoải mái quay hộp cơm trong lò vi sóng để làm nóng thức ăn.',12,'ca-men-com-apollo-3-ngan-apl.jpg','2021-05-30')

insert into product values (9,N'Máy lọc nước R.O tích hợp nóng lạnh ','650.000','1',N'Máy lọc nước cho gia đình',N'Máy lọc nước Sunhouse SHR76210CK sử dụng công nghệ lọc RO (lọc thẩm thấu ngược) được phát minh bởi một nhà khoa học người Mỹ vào những năm 50 của thế kỷ trước. Công nghệ RO hoạt động trên cơ chế chuyển động của các phân tử nước nhờ áp lực nén của máy bơm cao áp tạo ra một dòng chảy lớn đẩy các thành phần hóa học, kim loại nặng, tạp chất, virus, vi khuẩn... có trong nước chuyển động mạnh trôi ra ngoài theo đường nước thải.',20,'may-loc-nuoc-r-o-tich-hop-nong-lanh.jpg','2021-05-30')
insert into product values (9,N'Máy lọc nước để bàn Chungho','990.000','1',N'Máy lọc nước RO có chức năng làm nước lạnh',N'Chungho Iguassu Tiny 300 sử dụng màng RO số 1 của Mỹ (DOW) để loại bỏ tất cả các tạp chất như bùn đất, thuốc trừ sâu... các loại vi khuẩn có hại cho cơ thể, mang lại cho gia đình bạn nguồn nước sạch và an toàn. Nước sau lọc với máy lọc nước RO Chungho uống được trực tiếp mà không cần đun sôi. ',17,'may-loc-nuoc-de-ban-chungho.jpg','2021-05-30')

delete from [dbo].[boardnew]
Insert into boardnew(title, content, image_link, author, created) values (N' Có nên sử dụng quạt tháp không?', N'Quạt tháp thực sự là lựa chọn tuyệt vời cho bạn và gia đình trong mùa hè này, bởi vì nó sở hữu nhiều ưu điểm nổi bật mà loại quạt thông thường trước đây không có được. So với quạt truyền thống thì quạt tháp có thiết kế hiện đại với nhiều chức năng được bố trí tối giản trên thân quạt. Quạt truyền thống thiết kế cồng kềnh khiến nhiều người dùng không mấy hứng thú vì nó có thể chiếm nhiều không gian rất đẹp trong nhà.<br><br>Quạt tháp được thiết kế kiểu dáng hiện đại với các đường nét hết sức tinh tế. Để thiết bị này trong một ngôi nhà đẹp không chỉ giúp gia đình bạn chống lại cái oi bức của thời tiết mùa hè mà còn góp phần tạo nên “sự tiện nghi, sang trọng” cho không gian sống. Đặc biệt với kiểu dáng hình trụ, quạt tháp phù hợp với cả những nơi nhỏ hẹp. Khả năng làm mát tốt Với cấu trúc cánh quạt lồng tương tự như cánh quạt trong<br><br>máy lạnh quạt tháp chắc chắn sẽ tỏa ra lượng gió đều hơn, từ trên xuống dưới mà không làm tản gió giống như những cánh tròn, kích thước lớn của quạt điện thông thường. Ngoài ra quạt tháp còn có thể quay với nhiều góc độ khác nhau, cho người sử dụng có nhiều lựa chọn hướng gió thích hợp với vị trí ngồi.<br><br>Quạt tháp có thể tạo ra lượng gió đều, ổn định theo chiều từ trên xuống và quay nhiều góc độ khác nhau để làm mát trên diện rộng hay hẹp. Với tốc độ gió vừa phải nên người sử dụng quạt không thấy khó chịu hay làm ảnh hưởng đến sức khỏe khi dùng. Khả năng làm mát của quạt tháp không hề có sự thua kém bất kỳ loại quạt nào hiện nay. Sản phẩm có hệ thống điều khiển đơn giản với các nút bấm to, biểu tượng rõ ràng, màn hình LCD lớn hiển thị thông số hoạt động giúp việc kiểm soát, điều chỉnh dễ dàng hơn.Vì vậy quạt tháp thực sự là một thiết bị thông minh được trang bị nhiều tính năng hiện đại như: điều khiển từ xa, hiển thị anion, hẹn giờ, chế độ ngủ, chế độ tự nhiên, chế độ xoay. Một số dòng sản phẩm cao cấp còn có khả phun sương, tạo ion phát tán vào không khí để loại bỏ thành phần ô nhiễm và dị ứng,…<br><br>Khi sử dụng sẽ không còn phải nghe tiếng ồn hàng đêm, bởi quạt tháp vận hành vô cùng êm ái, cho cả gia đình một giấc ngủ thật ngon và thoải mái, dễ chịu. Có thể nói quạt tháp hầu như không gây tiếng ồn khi hoạt động.<br><br>', 'quat-hop-la-gi-quat-thap-la-gi.jpg', N'Nguyễn Hùng', '2021-05-31');
Insert into boardnew(title, content, image_link, author, created) values (N'Mẹo mua sắm đồ điện gia dụng siêu tiết kiệm', N'Trong thời buổi giá cả leo thang, mọi thứ đều đắt đỏ, làm cách nào để mua được những vật dụng cần thiết trong gia đình đầy đủ mà không mất chi phí quá nhiều, là điều mà nhiều người quan tâm. Dưới đây là một số mẹo mua sắm đồ gia dụng siêu tiết kiệm gợi ý dành cho bạn.<br><br>Sắm đồ gia dụng vào dịp khuyến mãi<br><br>Thông thường, các siêu thị bán đồ gia dụng hay tổ chức nhiều chương trình khuyến mãi giảm giá sản phẩm hoặc tặng quà vào các dịp lễ, Tết v.v... Nếu bạn mua sản phẩm vào thời gian này sẽ tiết kiệm được đáng kể chi phí sắm đồ gia dụng. Chẳng hạn, một số siêu thị giảm giá sản phẩm đến 20%, 30%, thậm chí một số sản phẩm giảm đến 50%. Hoặc khi bạn mua tivi sẽ được giảm giá kèm phiếu quà tặng, mua một bộ nồi sẽ được tặng tô, chén kèm theo. Như vậy, bạn đã tiết kiệm được chi phí mua thêm tô, chén trong nhà.<br><br>Sử dụng đồ gia dụng đa năng<br><br>Khi sử dụng đồ gia dụng đa năng, bạn sẽ tiết kiệm chi phí sắm đồ và diện tích đáng kể. Chẳng hạn, bạn mua một chiếc lò vi sóng có thêm chức năng nướng, bạn sẽ tiết kiệm được chi phí mua máy nướng. Hoặc khi bạn mua một chiếc máy xay sinh tố có thêm chức năng ép trái cây, bạn sẽ tiết kiệm được chi phí mua máy ép.<br><br>Chọn mua thiết bị có mẫu mã cũ<br><br>Sử dụng thiết bị có mẫu mã cũ không đồng nghĩa với việc sử dụng đồ cũ. Bởi vì, đó là các thiết bị có mẫu mã cũ nhưng vẫn là hàng mới. Các thiết bị đồ gia dụng như tủ lạnh, máy giặt, tivi, lò vi sóng... thường cho ra đời mẫu mã mới, vì vậy các sản phẩm có mẫu mã cũ sẽ được hạ giá đáng kể. Có nhiều người quan niệm rằng các thiết bị có mẫu mã cũ dùng không tốt bằng những sản phẩm có mẫu mã mới ra. Đó là quan niệm hoàn toàn sai lầm, những sản phẩm mới ra thường được tích hợp nhiều tính năng hiện đại. Trong khi, nhu cầu sử dụng của chúng ta không cần tới những tính năng đó, sẽ gây ra sự lãng phí.<br><br>', 'Meo-mua-do-gia-dung-sieu-tiet-kiem-2.jpg', N'Khắc Trung', '2021-05-31');
Insert into boardnew(title, content, image_link, author, created) values (N'Tủ lạnh SBS Aqua AQR-S541XASG thiết kế hiện đại, sử dụng công nghệ Twin Inverter tích kiệm điện hiệu quả', N'Tủ lạnh SBS Aqua Inverter 541 lít AQR-S541XASG mang đến sự sang trọng, thời thượng cho không gian sống của bạn với thiết kế hiện đại, tối giản, tông màu bạc tinh tế phối hợp hài hòa với mọi phong cách nội thất. Đặc biệt, cửa tủ làm bằng chất liệu thép kháng khuẩn, nhằm tránh nấm mốc và vi khuẩn tích tụ, góp phần bảo vệ sức khỏe người dùng và tăng độ bền cho sản phẩm.<br><br>Aqua Inverter AQR-S541XASG thuộc dòng tủ lạnh Side by Side với 2 cánh mở 2 bên cực kì tiện lợi, hai ngăn đông và ngăn mát được bố trí song song theo chiều dọc, bạn sẽ dễ dàng sắp xếp thực phẩm yêu thích trong tầm mắt, thuận tiện cho việc lấy ra mà không cần cúi xuống tìm kiếm. Bảng điều khiển cảm ứng thông minh được bố trí ngay trên cửa tủ cho phép người dùng kiểm soát và điều chỉnh chế độ phù hợp nhất một cách nhanh chóng mà không cần mở cửa làm thất thoát hơi lạnh. Tủ có chiều cao và chiều sâu hợp lý phù hợp với vóc dáng người Việt, giúp người dùng có thể lấy thực phẩm ở mọi vị trí, tránh bỏ quên thực phẩm nằm bên trong dẫn đến hư hỏng, lãng phí..<br><br>Công nghệ Twin Inverter được tích hợp trên tủ lạnh Aqua AQR-S541XASG sử dụng đồng thời máy nén Inverter và quạt Inverter cho khả năng tự động điều chỉnh hoạt động của máy nén với nhiều cấp độ, giúp duy trì nhiệt độ phù hợp, ổn định, làm lạnh nhanh chóng, vận hành êm ái, bền bỉ, tiết kiệm điện hiệu quả.<br><br>Công nghệ DEO Fresh được tích hợp trên Tủ lạnh Aqua Inverter AQR-S541XASG với các ion bạc Ag+ có khả năng diệt khuẩn mạnh mẽ loại bỏ vi khuẩn, nấm mốc và mùi hôi bên trong tủ. Thực phẩm được bảo quản trong môi trường trong lành, sạch khuẩn hạn chế nhiễm khuẩn, giữ được sự tươi ngon lâu hơn, không bị nhiễm mùi khó chịu làm mất đi hương vị ban đầu.<br><br>Tủ lạnh Aqua với hai ngăn rau quả riêng biệt tăng cường không gian dự trữ rau củ, trái cây, giúp việc phân loại và tìm kiếm thực phẩm trở nên dễ dàng, thuận tiện. Độ ẩm trong ngăn được cân bằng ngăn việc mất nước, giữ rau quả luôn tươi ngon, mọng nước, giữ được tối đa lượng vitamin. Hộc rau quả có thể kéo ra hoàn toàn ngay cả khi cửa tủ chỉ được mở ở góc 90 độ, thuận tiện khi cần lấy hoặc cất thực phẩm.<br><br>Ngoải ra, Chức năng ngày nghỉ Holiday trên tủ lạnh SBS Aqua Inverter 541 lít AQR-S541XASG cho phép bạn đóng cửa tủ khi đi vắng dài ngày mà không sợ phát sinh mùi hôi và nấm mốc. Tủ lạnh sẽ tự động cài đặt về 1 mức nhiệt tối ưu giúp ngăn ngừa nấm mốc mà không gây hao tốn nhiều điện năng.<br><br>', '18288_365630_tu-lanh-aqua.jpg', N'Văn Anh', '2021-05-30');



