<?php
        /*
        * Following code will delete a product from table
        * A product is identified by the product id (pid)
        */
        //array for JSON response
        $response = array();
        //include db connect class
        require_once__DIR__.'/db_connect.php';
        //connecting to db
        $db = new DB_CONNECT();
        //check for post data
        if(isset($_POST['pid'])){
            $pid = $_POST['pid'];
            //mysql delete row with matched pid
            $result = mysql_query("DELETE FROM products WHERE pid = '$pid'");
            //check if row deleted or not
            if(mysql_affected_rows() > 0){
                //success
                $response["success"] = 1;
                $response["message"] = "Product successfully deleted.";
                //echoing JSON response
                echo json_encode($response);
            } else {
                //no product found
                $response["success"] = 0;
                $response["message"] = "No product found.";
                //echoing JSON response
                echo json_encode($response);
            }
        } else {
            //required field is missing
            $response["success"] = 0;
            $response["message"] = "Required field(s) is missing!";
            //echoing JSON response
            echo json_encode($response);
        }
?>