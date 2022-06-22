# -*- coding: utf-8 -*-
"""
Created on Fri May  6 21:39:01 2022

@author: USER
"""

##Step 1
import pymysql
import mysql.connector

## Step 2
try:
    # Connect to the database
    connection = pymysql.connect(host='localhost',
                             user='root',
                             password='',
                             db='demo')
## Step3
    cursor=connection.cursor()
    # Create a new record
    sql = "INSERT INTO `employe` (`ID`, `name`) VALUES (%s, %s)"
    cursor.execute(sql, (1009,'Morgan'))
    # connection is not autocommit by default. So we must commit to save our changes.
    connection.commit()
## Step 4
    # Execute query
    sql = "SELECT * FROM `employe`"
    cursor.execute(sql)
    # Fetch all the records
    result = cursor.fetchall()
    for i in result:
        print(i)
#except Error as e:
  
## Step 5
finally:
    # close the database connection using close() method.
   # connection.close()
   pass