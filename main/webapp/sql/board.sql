
CREATE TABLE board(
        seq NUMBER NOT NULL,
        id VARCHAR2(20) NOT NULL,
        name VARCHAR2(40) NOT NULL,
        email VARCHAR2(40),
        subject varchar2(255) not null,
        content varchar2(4000) not null,
        
        ref number not null,
        lev number default 0 not null,
        step number default 0 not null,
        pseq number default 0 not null,
        reply number default 0 not null,
        
        hit number default 0,
        logtime date default sysdate
);