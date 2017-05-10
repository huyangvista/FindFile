package demo;

import vdll.data.msql.AISql;

public class sys_log{

@AISql
public String id;
@AISql
public String type;
@AISql
public String title;
@AISql
public String create_by;
@AISql
public String create_date;
@AISql
public String remote_addr;
@AISql
public String user_agent;
@AISql
public String request_uri;
@AISql
public String method;
@AISql
public String params;
@AISql
public String exception;

}
