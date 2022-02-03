create table member(
id varchar(20) primary key not null,
password varchar(100) not null,
email varchar(50) not null
);

create table photo(
photo_id int primary key not null,
member_id varchar(20) not null,
image mediumblob not null,
loc_info varchar(200) not null,
time_info timestamp,
like_count int not null default 0,
foreign key (member_id) references member(id)
);