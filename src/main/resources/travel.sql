/*==============================================================*/
/* create table                                          */
/*==============================================================*/
drop table if exists tab_user;
drop table if exists tab_category;
drop table if exists tab_viewpoint;


drop table if exists tab_favorite;
drop table if exists tab_route_img;
drop table if exists tab_seller;

/*==============================================================*/
/* Table: tab_user                                              */
/*==============================================================*/
create table tab_user
(
    uid                  int not null auto_increment,
    email                varchar(50) not null,
    username             varchar(10) not null,
    password             varchar(20) not null,
    birthday             date,
    gender               char(6),
    telephone            varchar(15),
    status               char(1),
    code				 varchar(50),

    primary key (uid),
    unique key UK_user_email (email),
    unique key UK_user_code (code)
);

/*==============================================================*/
/* Table: tab_category                                          */
/*==============================================================*/
create table tab_category
(
    cid                  int not null auto_increment,
    cname                varchar(50) not null,
    primary key (cid),
    unique key UK_category_categoryname (cname)
);
insert  into tab_category (cname)
values ('Leisure'), ('Neighbourhoods'), ('Arts'), ('Architecture'), ('History'), ('Culture'), ('Nature');

/*==============================================================*/
/* Table: tab_viewpoint                                             */
/*==============================================================*/
create table tab_viewpoint
(
    vid                  int not null auto_increment,
    vname                varchar(100) not null,
    location             varchar(100) not null,
    introduce            varchar(500),
    detail               varchar(5000),
    cid                  int not null,
    favCount             int default 0,
    primary key (vid)
);
alter table tab_viewpoint add constraint FK_category_viewpoint foreign key (cid)
    references tab_category (cid) on delete restrict on update restrict;
insert into tab_viewpoint (vname, location, introduce, detail, cid) values
('Chinatown', '2 Banda Street, Singapore 059962','Explore a Chinatown like no other, and be enchanted by historic temples, hip bars and the heritage of Singapore.',
 'Once an enclave for Singapore’s Chinese immigrant population, the Chinatown of today is much-beloved for its blend of old and new, with historic temples and traditional medicinal halls sitting alongside bold new bars and trendy lifestyle shops.\n You’ll be able to spend an entire day exploring this vibrant district, which encompasses the neighbourhoods of Tanjong Pagar, Bukit Pasoh, Kreta Ayer and Telok Ayer. Whether you’re exploring century-old temples or making new friends at hip watering holes, there’s always a new experience to be had in Chinatown.',
 2),
('National Gallery Singapore','1 St Andrew''s Road, Singapore 178957','Take in the region’s newest and largest museum of modern Singapore and Southeast Asian art housed within two of Singapore’s awe-inspiring national monuments.',
 'Fittingly located in the heart of the Civic District, the Gallery is housed in the City Hall and the former Supreme Court—two iconic buildings that have played a monumental role in Singapore''s history. Utmost care was taken to ensure that preservation guidelines for these two national monuments were being upheld even as they were being remodelled into a state-of-the-art museum for the public.\n Dedicated to curating a collection that will provide insights into the unique art, heritage and history in the region, the Gallery is a must-visit destination in Singapore. At 64,000 square metres, it is the largest visual arts venue in Singapore and one of the largest in the region.',
 3),
('Gardens by the Bay','18 Marina Gardens Drive, Singapore 018953','The lush and beautiful Gardens by the Bay is dominated by the sleekly sculptured biodomes—marvels of architecture, design and engineering.',
 'It’s hard to miss the sprawling 101-hectare lot right by the water in Marina Bay. Two huge futuristic structures rise out of the greenery at Gardens by the Bay, which was designed with environmental sustainability in mind.\n These are the Flower Dome and the Cloud Forest cooled conservatories, which was listed in the 2015 Guinness World Records as the world’s largest glass greenhouse. The freestanding unsupported glass roofs enclose expansive spaces, unmarred by any pillar or column.\nBesides ultra-modern design, the conservatories also use cutting-edge technologies for better energy efficiency.',
 4),
('Sun Yat Sen Memorial Hall','12 Tai Gin Road, Singapore 327874','This museum is a fitting tribute to the intriguing life and times of Chinese revolutionary leader Dr Sun Yat Sen.',
 'Set in a two-storey colonial villa, the museum honours Dr Sun, who was the leader of the revolutionary movement that overthrew the Qing dynasty, and a pivotal figure in Chinese and Southeast Asian history.\nHoused in the same stronghold of the Chinese Revolutionary Alliance, where the Tong Meng Hui Singapore Branch was found, the museum zeroes in on Dr Sun’s work and impact on Chinese communities in the region during the revolutionary movement.\nThe alliance, known as Tong Meng Hui, was influential throughout Southeast Asia and paved the way for the end of the Qing dynastic rule.',
 5),
('Haw Par Villa','262 Pasir Panjang Road, Singapore 118628','Embark on an unforgettable journey into Chinese folklore, legend and mythology at the Haw Par Villa Asian cultural park.',
 'One of the oldest existing cultures in the world today, Chinese history stretches back across millennia, and is filled with fascinating stories. History buffs looking to journey through the richness of Chinese tradition and religious beliefs should pay a visit to Haw Par Villa, an Asian cultural park that’s a repository of folklore and storied myths.',
 6),
('Singapore Zoo','80 Mandai Lake Road, Singapore 729826','Get up close with animals of all stripes, and walk on the wild side when you visit the Singapore Zoo.',
 'Located on the north-western side of the island, the Singapore Zoo is a haven for wondrous wildlife and a must-visit for animal lovers.\nThis beloved establishment first opened its gates to the public in 1973, and has since become one of the best rainforest zoos in the world.\nBesides being home to over 2,800 animals from 300 species—including crocodiles, Malayan tapirs and white tigers—the zoo has won a trove of international and local awards.',
 7),

('Marina Bay Sands','10 Bayfront Avenue, Singapore 018956','This iconic integrated resort boasts luxury accommodations, upscale shopping and an infinity pool with unparalleled views of the city.',
 'Marina Bay Sands is a destination for those who appreciate luxury. An integrated resort notable for transforming Singapore’s city skyline, it comprises three 55-storey towers of extravagant hotel rooms and luxury suites with personal butler services. In addition, its architecture is made complete with the Sands SkyPark which crowns the three towers.',
 1),
('Adventure Cove Waterpark','8 Sentosa Gateway, Sentosa Island, Singapore 098269','Make a big splash at this aquatic adventure park at Resorts World™ Sentosa.',
 'Beat the heat with a day out at Adventure Cove Waterpark. Seven thrilling water rides, such as Pipeline Plunge, will get your heart rate up, as you plunge down an elevated chute and careen across banked turns and radical twists, before splashing out in a pool of water.',
 1),
('Singapore River Bumboat Cruise','3E River Valley Road (beside G-Max Reverse Bungy), Singapore 179024','Hop on a bumboat with the Singapore River Cruise, and acquaint yourself with Singapore’s history and modernity in one classic experience.',
 'During our nation’s colonial era, the Singapore River was a thriving hub of commerce, where godowns filled with wares sat along the waterway’s quays, and flotillas of bumboats plied their trade.',
 1),
('Universal Studios Singapore','8 Sentosa Gateway, Sentosa Island, Singapore 098269','Step into the glamorous world of movies at this world-class theme park located within Resorts World Sentosa.',
 'Southeast Asia''s first Hollywood movie theme park, Universal Studios Singapore, features an enticing selection of attractions, rides and entertainment for families and thrill seekers.',
 1),
('S.E.A. Aquarium','Sentosa Island, 8 Sentosa Gateway, Singapore 098269','Journey into the realms beneath the waves at the S.E.A. Aquarium and discover more than 100,000 marine animals.',
 'No matter the perspective, the aquarium within Resorts World Sentosa is a magical marine world with more than 100,000 underwater animals from approximately 1,000 species, including leopard sharks, goliath groupers and squadrons of manta rays.',
 1),
('Wild Wild Wet','Downtown East. 1 Pasir Ris Close, Singapore 519599','With over 15 attractions for both kids and the young at heart, Wild Wild Wet is a great place to experience thrills and spills with the entire family.',
 'First opened in 2004, the water park has since expanded to over twice its size and launched two new rides.\nVortex—an 18.5-metre-high, 360-degree water slide—will certainly appeal to adrenaline lovers. Thrill-loving families who’re looking to bond and engage in some healthy competition with their loved ones should head over to the Kraken Racer, which features competitive mat-racing for up to four people.\nThe park even boasts a white-water rafting experience with Ular Lah—a super flume ride that challenges you to brave the rapids with five other companions.',
 1),

('Science Centre','15 Science Centre Road, Singapore 609081','Delve into a world of scientific discovery at Science Centre Singapore, a four-decade-old educational establishment that promotes creative learning in a dynamic environment.',
 'With a wide array of enrichment programmes, exhibitions, live shows and movies, this is a great place to inspire youngsters with aspirations of becoming fledgling scientists.',
 1),
('Esplanade','1 Esplanade Drive, Singapore 038981','Catch a non-stop line-up of world-class performances at Singapore’s premier arts centre, situated along the scenic Marina Bay.',
 'Pop by Esplanade at any time and you’ll find it hard not to be infected by its palpable creative vibe, whether it’s the ever-changing, larger than life visual arts display near the main entrance or the world-class performances staged here.',
 1),
('Kaboodle','88 East Coast Road #02-06, Singapore 423371','An indoor space that uses play as a medium to build, craft and experiment.',
 'Beside a plethora of block puzzles, craft kits and colouring material, Kaboodle also organises holiday events like nerf gun and building competitions. Walk-ins are on a first-come, first served basis, so be sure to book on an appointment on their website before heading over!',
 1),
('Café Melba','90 Goodman Road, Block N #01-56, Singapore 439053','Located within the lush green compound of Goodman Art Centre, Café Melba is a favourite haunt of families looking to spend a lively afternoon with their little ones.',
 'This 120-seater café dishes out Western brunch classics like eggs benedict, fluffy buttermilk pancakes drenched in maple syrup and a hearty English-style breakfast.\nWhile you’re digging in, your kids can spend their time romping in the space’s bouncy castle, or playing tag at the café’s lawn. Be sure to check out the restaurant’s kids club for tantalising offers, such as free dining for children on Mondays.',
 1),
('PAssion WaVe (Pasir Ris Park)','125 Elias Road, Singapore 519926','Here, take a bus to PAssion WaVe which offers adventurous families a slew of water sports to try.',
 'Try kayaking or laser sailing on the seas (if you’re qualified), or combat the heights with abseiling and sport climbing. Families looking to relax can take a leisurely walk on the Mangrove Boardwalk—one of the two protected swamps in Singapore—which is home to native flora and fauna. Now, see if you can spot those mudskippers or mud crabs.',
 1),
('Forest Adventure','Bedok Reservoir Road, Singapore 479244','Swing down a flying fox, teeter across a suspension bridge, or jump from a treetop at Forest Adventure, Singapore’s first and only tree top obstacle course.',
 'The young—and young-at-heart—can test their limits here with various courses, set amidst the foliage of Bedok Reservoir Park.\nThe Kids Course comes with a continuous safety line, so be assured that your kid is in good hands. Those with a fear of heights can skate, run, cycle or even bird-watch at this tranquil spot.',
 1),

('Singapore Flyer','30 Raffles Avenue, Singapore 039803','This giant observation wheel offers 360-degree city views, a panorama that stretches to parts of Malaysia and Indonesia on a clear day.',
 'A giant observation wheel that stands amidst the skyscrapers in the Singapore skyline, the Singapore Flyer is the go-to attraction for the most magnificent views of our city.\nA scenic spin on the Singapore Flyer takes you 165 metres above ground, or as high as 42 storeys, as you marvel at the spectacular scenery below.',
 1),
('Merlion Park','One Fullerton, Singapore 049213','Meet the local legend and globally-recognised icon with a visit to Merlion Park.',
 'Travellers acquainted with Singapore will probably already know of our city’s national icon—the mythical Merlion, which possesses the body of a fish and the head of a lion.\nOne of the most famous depictions of this iconic symbol is the statue found at Merlion Park—a scenic spot located at One Fullerton, Singapore, near the Central Business District.',
 1),
('Seletar Aerospace Park','3 Park Lane Level 2, Singapore 798387','A hidden gem for an idyllic escape, Seletar Aerospace Park houses restaurants flanked by lush greenery, making it the perfect spot for a quiet getaway.',
 'This locale was once home to an Ex-British Royal Air Force Station—a fact that you may want to mention to impress your date. The space is home to 32 colonial bungalows, making it a great area to stroll through for history buffs with an interest in 19th century history.',
 1),
('Henderson Waves','Henderson Road, Singapore','Lush jungle is broken up with a seriously creative twist in the fantastic form of the Henderson Waves bridge.',
 'At 36 metres above ground, the Henderson Waves bridge is the highest pedestrian bridge in Singapore. Unveiled in 2008, its fantastical shape has lent an unexpected jolt of design savvy to the lush green belt in the south of Singapore.',
 1),
('Museum of Ice Cream','100 Loewen Road, Dempsey, Singapore, Singapore 248837','This vibrant attraction is bound to delight your senses and tantalise your inner foodie.',
 'Forget about Willy Wonka’s chocolate factory—travellers craving a foray into a wonderland of sweet surprises should pay a visit to the Museum of Ice Cream (MOIC) Singapore instead.',
 1),
('The Projector’s','6001 Beach Road #05-00, Singapore 199589','Calling all film buffs: If cult classics, psychological horror and world cinema tickle your fancy, then The Projector’s where to spend your night at.',
 'Situated on the fifth floor of Golden Mile Tower, the indie movie theatre is housed in the Golden Theatre, our largest cinema during the 1970s. While most of the interior has been redesigned, it still retains its retro theatre flip-up seats. The Projector occasionally screens local indie movies and award-winning flicks, too.',
 1);


/*==============================================================*/
/* Table: tab_favorite                                          */
/*==============================================================*/
create table tab_favorite
(
    rid                  int not null,
    date                 date not null,
    uid                  int not null,
    primary key (rid, uid)
);

/*==============================================================*/
/* Table: tab_route_img                                         */
/*==============================================================*/
create table tab_route_img
(
    rgid                 int not null auto_increment,
    rid                  int not null,
    bigPic               varchar(200) not null,
    smallPic             varchar(200),
    primary key (rgid)
);

/*==============================================================*/
/* Table: tab_seller                                            */
/*==============================================================*/
create table tab_seller
(
    sid                  int not null auto_increment,
    sname                varchar(200) not null,
    consphone            varchar(20) not null,
    address              varchar(200),
    primary key (sid),
    unique key AK_Key_2 (sname)
);
alter table tab_favorite add constraint FK_route_favorite foreign key (rid)
    references tab_route (rid) on delete restrict on update restrict;

alter table tab_favorite add constraint FK_user_favorite foreign key (uid)
    references tab_user (uid) on delete restrict on update restrict;

alter table tab_route add constraint FK_seller_route foreign key (sid)
    references tab_seller (sid) on delete restrict on update restrict;

alter table tab_route_img add constraint FK_route_routeimg foreign key (rid)
    references tab_route (rid) on delete restrict on update restrict;