<?php

defined("BASEPATH") or exit("No direct script access allowed");

require APPPATH . "/libraries/REST_Controller.php";

use Restserver\Libraries\REST_Controller;

class Register extends REST_Controller
{
    function __construct($config = "rest")
    {
        parent::__construct($config);
        $this->load->library('form_validation');
        $this->load->database();
    }

    public function index_post()
    {
        // $data = array(
        //     "username"      => $this->post("username"),
        //     "email"         => $this->post("email"),
        //     "password"      => $this->post("password"),
        //     "no_hp"         => $this->post("no_hp"),
        //     "jenis_kelamin" => $this->post("jenis_kelamin"),
        //     "angkatan"      => $this->post("angkatan")
        // );

        // $insert = $this->db->insert("users", $data);
        // if($insert){
        //     $this->response($data, 200);
        // } else {
        //     $this->response(array("status" => "fail", 502));
        // }
        
        $this->form_validation->set_rules("username", "Username", "required|trim");
        $this->form_validation->set_rules("email", "Email", "required|trim|valid_email");
        $this->form_validation->set_rules("password", "Password", "required|trim");
        $this->form_validation->set_rules("no_hp", "No_hp", "required|trim");
        $this->form_validation->set_rules("jenis_kelamin", "Jenis_kelamin", "required");
        $this->form_validation->set_rules("angkatan", "Angkatan", "required|trim");
        
        $runVal = $this->form_validation->run();

        if($runVal == true){
            $data = [
                "username"      => htmlspecialchars($this->input->post("username", true)),
                "email"         => htmlspecialchars($this->input->post("email", true)),
                "password"      => password_hash($this->input->post("password"), PASSWORD_DEFAULT),
                "no_hp"         => $this->input->post("no_hp"),
                "jenis_kelamin" => $this->input->post("jenis_kelamin"),
                "angkatan"      => $this->input->post("angkatan")
            ];
            $regisStatus = $this->db->insert("users", $data);
            if($regisStatus){
                $response["status"] = true;
                $response["message"] = "Registrasi berhasil";
                $response["data"] = [
                    "username" => $data["username"],
                ];         
                // $this->response(array("status" => "success", "message" => "Registrasi berhasil", "code" => 200));
            }else{
                $response["status"] = false;
                $response["message"] = "Registrasi gagal";
            }
        }else{
            $response["status"] = false;
            $response["message"] = "Masukan data dengan benar!";
        }
        $json = json_encode($response, JSON_PRETTY_PRINT);
        echo $json;
        
        
        
    }
}