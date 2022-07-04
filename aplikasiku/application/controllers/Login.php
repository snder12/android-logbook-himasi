<?php

defined("BASEPATH") or exit("No direct script access allowed");

require APPPATH . "/libraries/REST_Controller.php";

use Restserver\Libraries\REST_Controller;

class Login extends REST_Controller
{
    function __construct($config = "rest")
    {
        parent::__construct($config);
        $this->load->library('session');
        $this->load->database();
    }

    public function index_post(){
        $username = $this->input->post("username");
        $password = $this->input->post("password");

        $response = [];

        $users = $this->db->get_where("users", ["username" => $username])->row_array();

        if($users == true){
            if(password_verify($password, $users["password"])){
                $data = [
                    "username" => $users["username"],
                ];

                // $data["users"] = $this->db->get_where("users", ["username" => $this->session->userdata("username")])->row_array();

                $this->session->set_userdata($data);
                // $this->response(array(
                //     "status" => "true", 
                //     "message" => "Login berhasil", 
                //     "data" => $data
                //     )
                // );

                $response["status"] = true;
                $response["message"] = "Login Berhasil";
                $response["data"] = [
                    "user_id" => $users["id"], 
                    "username" => $users["username"],
                ];
                
                // $this->response(array("data" => $data,"messages" => "Login berhasil", "code" => 200));
            }else{
                $response["status"] = false;
                $response["message"] = "Password salah";
            }
        }else{
            $response["status"] = false;
            $response["message"] = "User tidak ditemukan, silahkan Register";
        }

        $json = json_encode($response, JSON_PRETTY_PRINT);
        echo $json;
    }
}