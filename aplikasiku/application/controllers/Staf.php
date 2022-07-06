<?php

defined("BASEPATH") or exit("No direct script access allowed");

require APPPATH . "/libraries/REST_Controller.php";

use Restserver\Libraries\REST_Controller;

class Staf extends REST_Controller
{
    function __construct($config = "rest")
    {
        parent::__construct($config);
        $this->load->database();
    }

    public function index_get()
    {

        // level 0 = anggota
        // level 1 = staff
        $this->db->select("id_anggota, npm, nama, angkatan, jabatan");
        $this->db->where("level", 1);
        $staf = $this->db->get("anggota")->result();
        $this->response(array("result"=>$staf, 200));

        // $response["status"] = true;
        // $response["message"] = "Staf berhasil ditampilkan";
        // $response["data"] = $staf;   
        
        // $json = json_encode($response, JSON_PRETTY_PRINT);
        // echo $json;

           

        

        
    }
}