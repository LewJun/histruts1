--
-- File generated with SQLiteStudio v3.2.1 on Thu Apr 11 00:09:43 2019
--
-- Text encoding used: UTF-8
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Table: emp
DROP TABLE IF EXISTS emp;

CREATE TABLE emp (
    empno    INTEGER   PRIMARY KEY AUTOINCREMENT,
    ename    TEXT (32) NOT NULL,
    job      TEXT,
    mgr      INTEGER,
    hiredate DATE,
    deptno   INTEGER
);

INSERT INTO emp (empno, ename, job, mgr, hiredate, deptno) VALUES (7499, 'ALLEN', 'SALESMAN', 7698, '1981-02-20', 30);
INSERT INTO emp (empno, ename, job, mgr, hiredate, deptno) VALUES (7521, 'WARD', 'SALESMAN', 7698, '1981-02-22', 30);
INSERT INTO emp (empno, ename, job, mgr, hiredate, deptno) VALUES (7566, 'JONES', 'MANAGER', 7839, '1981-04-02', 20);
INSERT INTO emp (empno, ename, job, mgr, hiredate, deptno) VALUES (7654, 'MARTIN', 'SALESMAN', 7698, '1981-09-28', 30);
INSERT INTO emp (empno, ename, job, mgr, hiredate, deptno) VALUES (7698, 'BLAKE', 'MANAGER', 7839, '1981-05-01', 30);
INSERT INTO emp (empno, ename, job, mgr, hiredate, deptno) VALUES (7782, 'CLARK', 'MANAGER', 7839, '1981-06-09', 10);
INSERT INTO emp (empno, ename, job, mgr, hiredate, deptno) VALUES (7839, 'KING', 'PRESIDENT', NULL, '1981-11-17', 10);
INSERT INTO emp (empno, ename, job, mgr, hiredate, deptno) VALUES (7844, 'TURNER', 'SALESMAN', 7698, '1981-09-08', 30);
INSERT INTO emp (empno, ename, job, mgr, hiredate, deptno) VALUES (7900, 'JAMES', 'CLERK', 7698, '1981-12-03', 30);
INSERT INTO emp (empno, ename, job, mgr, hiredate, deptno) VALUES (7902, 'FORD', 'ANALYST', 7566, '1981-12-03', 20);
INSERT INTO emp (empno, ename, job, mgr, hiredate, deptno) VALUES (7934, 'MILLER', 'CLERK', 7782, '1982-01-23', 10);

-- Table: permission
DROP TABLE IF EXISTS permission;

CREATE TABLE permission (
    id    INTEGER PRIMARY KEY AUTOINCREMENT,
    name  TEXT    NOT NULL,
    desc_ TEXT,
    url   TEXT
);

INSERT INTO permission (id, name, desc_, url) VALUES (1, 'addEmp', '增加EMP', '/empAction.do?method=save');
INSERT INTO permission (id, name, desc_, url) VALUES (2, 'deleteEmp', '删除EMP', '/empAction.do?method=delete');
INSERT INTO permission (id, name, desc_, url) VALUES (3, 'editEmp', '编辑EMP', '/empAction.do?method=edit');
INSERT INTO permission (id, name, desc_, url) VALUES (4, 'updateEmp', '修改EMP', '/empAction.do?method=update');
INSERT INTO permission (id, name, desc_, url) VALUES (5, 'listEmp', '查看EMP', '/empAction.do?method=index');
INSERT INTO permission (id, name, desc_, url) VALUES (6, 'getEmpListJsonAjax', 'getEmpList', '/empAction.do?method=getEmpList');
INSERT INTO permission (id, name, desc_, url) VALUES (7, 'mockException', 'mockException', '/empAction.do?method=mockException');

-- Table: role
DROP TABLE IF EXISTS role;

CREATE TABLE role (
    id    INTEGER PRIMARY KEY AUTOINCREMENT,
    name  TEXT    NOT NULL,
    desc_ TEXT
);

INSERT INTO role (id, name, desc_) VALUES (1, 'admin', '超级管理员');
INSERT INTO role (id, name, desc_) VALUES (2, 'admin2', '二级管理员');
INSERT INTO role (id, name, desc_) VALUES (3, 'empManager', 'EMP管理员');

-- Table: role_permission
DROP TABLE IF EXISTS role_permission;

CREATE TABLE role_permission (
    id            INTEGER PRIMARY KEY AUTOINCREMENT,
    id_role       INTEGER NOT NULL,
    id_permission INTEGER NOT NULL
);

INSERT INTO role_permission (id, id_role, id_permission) VALUES (1, 1, 1);
INSERT INTO role_permission (id, id_role, id_permission) VALUES (2, 1, 2);
INSERT INTO role_permission (id, id_role, id_permission) VALUES (3, 1, 3);
INSERT INTO role_permission (id, id_role, id_permission) VALUES (4, 1, 4);
INSERT INTO role_permission (id, id_role, id_permission) VALUES (5, 1, 5);
INSERT INTO role_permission (id, id_role, id_permission) VALUES (6, 1, 6);
INSERT INTO role_permission (id, id_role, id_permission) VALUES (7, 1, 7);
INSERT INTO role_permission (id, id_role, id_permission) VALUES (8, 2, 5);
INSERT INTO role_permission (id, id_role, id_permission) VALUES (57, 2, 6);
INSERT INTO role_permission (id, id_role, id_permission) VALUES (58, 2, 7);
INSERT INTO role_permission (id, id_role, id_permission) VALUES (59, 3, 7);
INSERT INTO role_permission (id, id_role, id_permission) VALUES (60, 3, 6);
INSERT INTO role_permission (id, id_role, id_permission) VALUES (61, 3, 5);
INSERT INTO role_permission (id, id_role, id_permission) VALUES (62, 3, 4);
INSERT INTO role_permission (id, id_role, id_permission) VALUES (63, 3, 3);
INSERT INTO role_permission (id, id_role, id_permission) VALUES (64, 3, 2);
INSERT INTO role_permission (id, id_role, id_permission) VALUES (65, 3, 1);

-- Table: user
DROP TABLE IF EXISTS user;

CREATE TABLE user (
    id       INTEGER    PRIMARY KEY AUTOINCREMENT,
    username TEXT       NOT NULL
                        UNIQUE,
    password TEXT       NOT NULL,
    salt     TEXT (100)
);

INSERT INTO user (id, username, password, salt) VALUES (1, 'z3', '39cd294037a9dc680b2fd697530b039e', 'Lhz25eNcWWrDi+02ZLNZqw==');
INSERT INTO user (id, username, password, salt) VALUES (2, 'l4', '47b4b7e4983e5a0a1cf92bb058b23114', 'x+F8OWTEsw/RasinBUqyyg==');
INSERT INTO user (id, username, password, salt) VALUES (4, 'w5', 'c7a61766de684023148131f0589c92f6', 'QDnBpzlkEpFvdpWXB7f5kA==');

-- Table: user_role
DROP TABLE IF EXISTS user_role;

CREATE TABLE user_role (
    id      INTEGER PRIMARY KEY AUTOINCREMENT,
    id_user INTEGER NOT NULL,
    id_role INTEGER NOT NULL
);

INSERT INTO user_role (id, id_user, id_role) VALUES (1, 2, 2);
INSERT INTO user_role (id, id_user, id_role) VALUES (2, 1, 1);

-- Index: idx_empno
DROP INDEX IF EXISTS idx_empno;

CREATE INDEX idx_empno ON emp (
    empno
);


-- Index: idx_ename
DROP INDEX IF EXISTS idx_ename;

CREATE INDEX idx_ename ON emp (
    ename
);


-- Index: idx_id_role_permission
DROP INDEX IF EXISTS idx_id_role_permission;

CREATE UNIQUE INDEX idx_id_role_permission ON role_permission (
    id_role,
    id_permission
);


-- Index: idx_id_user_role
DROP INDEX IF EXISTS idx_id_user_role;

CREATE UNIQUE INDEX idx_id_user_role ON user_role (
    id_user,
    id_role
);


-- Index: idx_name
DROP INDEX IF EXISTS idx_name;

CREATE UNIQUE INDEX idx_name ON role (
    name
);


COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
