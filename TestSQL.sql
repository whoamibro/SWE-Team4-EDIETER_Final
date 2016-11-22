drop table User;
create table User ( 
id varchar(20) not null,
password varchar(20) not null,
name varchar(10) not null,
space int,
currentPowerUsage double,

primary key (id)
);

drop table Product;
create table Product (
id varchar(20) not null,
type int not null,
model varchar(20) not null,
usingTime int not null,
availableTime int not null,
power int not null,
grade int not null,
powerFreezing int not null,
powerHeating int not null,
foreign key (id) references User(user)
);

create table Product (

);

create table student(
student_no int Not null, 
student_name varchar(10) Not null,
student_year int Not null,
student_addr varchar(100),
student_tel varchar(14),
student_birth date,
primary key (student_no)
);

create table Grade(
student_no int Not null,
grade_kor int,
grade_eng int,
grade_math int,
primary key (student_no),
CONSTRAINT grade_student_no_fk
FOREIGN KEY (student_no) REFERENCES student(student_no)
);

drop table scholarship;
create table scholarship(
scholar_name varchar(10) NOT NULL, 
scholar_percent int,
scholar_money int,
primary key (scholar_name)
);


INSERT INTO STUDENT VALUES
        (20111001, '�質��', 4, '����Ư���� ���ʱ� ���ʵ� ��� ���....', '011-111-1111', '1992-08-09');

INSERT INTO STUDENT VALUES
        (20111002, '�̿���', 4, '����Ư���� ������ �Ż絿 ��� ���....', '011-222-1111', '1992-08-09');

INSERT INTO STUDENT VALUES
        (20111003, '�ڿ���', 4, '����Ư���� ������ �ֹ��� ��� ���....', '011-222-1112', '1992-09-09');

INSERT INTO STUDENT VALUES
        (20121001, '������', 3, '����Ư���� ����� ��赿....', '011-212-1111', '1993-08-09');

INSERT INTO STUDENT VALUES
         (20121002, '���ʽ�', 3, '����Ư���� ������ ������....', '011-212-2222', '1993-10-09');

INSERT INTO STUDENT VALUES
     (20121003, '������', 3, '����Ư���� ����� �߰赿....', '011-212-1122', '1993-11-09');

INSERT INTO STUDENT VALUES
       (20131001, '������', 2, '����Ư���� ���ϱ� ���ϵ�....', '010-212-1122', '1994-12-09');

--
INSERT INTO STUDENT VALUES
       (20131002, '���Ǽ�', 2, '����Ư���� ������ ������....', '010-212-1120', '1994-12-09');

INSERT INTO STUDENT VALUES
         (20141001, '�̹̿�', 1, '����Ư���� ����� �ϰ赿....', '010-211-1120', '1995-12-09');

INSERT INTO STUDENT VALUES
         (20131003, '���Ǽ�', 2, '����Ư���� ������ ������....', '010-212-1120', '1994-12-09');

INSERT INTO STUDENT VALUES
        (20141002, '������', 1, '����Ư���� ������ �Ͽ��� ...', '010-3642-7777', '1995-08-08');

INSERT INTO STUDENT VALUES
        (20141003, '�̳���', 1, '����Ư���� ����� �ϰ赿 ...', '02)745-6666', '1995-10-31');

INSERT INTO STUDENT VALUES
        (20141004, '�۾���', 1, '������ ��õ�� ��赿 ...', '011-2222-111', '1995-09-19');

INSERT INTO STUDENT VALUES
        (20141005, '�̹���', 1, '����� ���Ǳ� ��õ�� ...', '010-1234-01234','1995-03-08');

INSERT INTO STUDENT VALUES
        (20141006, '�質��', 1, '��� ���� �Ͼ��� ...', '010-256-2685', '1995-06-28');

delete from grade where student_no = 20141002;
delete from student where student_no = 20141002;

INSERT INTO GRADE VALUES
        (20141001, 90, 89, 90);

INSERT INTO GRADE VALUES
        (20141002, 100, 100, 100);

INSERT INTO GRADE VALUES
        (20141003, 57, 68, 82);

INSERT INTO GRADE VALUES
        (20141004, 92, 95, 35);

INSERT INTO GRADE VALUES
        (20141005, 75, 75, 68);

INSERT INTO GRADE VALUES
        (20141006, 85, 81, 83);

INSERT INTO GRADE VALUES
        (20131001, 71, 100, 92);

INSERT INTO GRADE VALUES
        (20131002, 87, 90, 89);

INSERT INTO GRADE VALUES
        (20131003, 82, 76, 60);

INSERT INTO GRADE VALUES
        (20121001, 100, 92, 75);

INSERT INTO GRADE VALUES
        (20121002, 79, 46, 57);

INSERT INTO GRADE VALUES
        (20121003, 50, 68, 66);

INSERT INTO GRADE VALUES
        (20111001, 100, 98, 99);

INSERT INTO GRADE VALUES
        (20111002, 75, 68, 90); 

INSERT INTO GRADE VALUES
        (20111003, 74, 98, 100);


INSERT INTO scholarship VALUES ('�������б�', 10, 1200000);

INSERT INTO scholarship VALUES ('��Ƽ�ƽ����б�', 30, 400000);

INSERT INTO scholarship VALUES ('�е����б�', 40, 300000);

