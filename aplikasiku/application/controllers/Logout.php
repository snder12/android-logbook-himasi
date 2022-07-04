<?php

defined("BASEPATH") or exit("No direct script access allowed");

require APPPATH . "/libraries/REST_Controller.php";

use Restserver\Libraries\REST_Controller;

class Logout extends REST_Controller
{
    function __construct($config = "rest")
    {
        parent::__construct($config);
        $this->load->library('session');
        $this->load->database();
    }

    public function index_post(){
        $this->session->unset_userdata("username");
        $this->session->unset_userdata("isLoggedIn");
        $response["status"] = true;
        $response["message"] = "Logout Berhasil";

        $json = json_encode($response, JSON_PRETTY_PRINT);
        echo $json;

        // mengecek sudah logout atau belum
        // echo '<pre>'; print_r($this->session->all_userdata());exit;
    }
}