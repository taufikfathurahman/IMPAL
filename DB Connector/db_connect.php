<?php
    class DB_CONNECT{
        //constructor
        function__cunstruct(){
            //connecting to database
            $this->connect();
        }
        //destructor
        function__destruct(){
            //closing db connection
            $this->close();
        }
        //function to connect with the database
        function connect(){
            //import database connection variables
            require_once__DIR__.'/db_config.php';
            //connection to MySQL database
            $con = mysql_connect(DB_SERVER, DB_USER, DB_PASSWORD) or die(mysql_error());
            //selecting database
            $db = mysql_select_db(DB_DATABASE) or die(mysql_error());
            //returning connection cursor
            return $con;
        }
        //function to close db connection
        function close(){
            //closing the database connection
            mysql_close();
        }
    }
?>