import mysql.connector
# faire quelque chose d'utile avec la connexion
try:

    db = mysql.connector.connect(
    host="",
    user="root",
    password="",
    database="demo"
)

## Step3
    cursor=db.cursor()
    # Create a new record
    sql = "INSERT INTO `employe` (`ID`, `name`) VALUES (%s, %s)"
    cursor.execute(sql, (1,'Le D'))
    db.commit()

finally:
    pass




db.close()
