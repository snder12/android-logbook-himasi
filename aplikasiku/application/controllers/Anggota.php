<?php

defined("BASEPATH") or exit("No direct script access allowed");

require APPPATH . "/libraries/REST_Controller.php";

use Restserver\Libraries\REST_Controller;

class Anggota extends REST_Controller
{
    function __construct($config = "rest")
    {
        parent::__construct($config);
        $this->load->database();
    }

    public function index_get()
    {
        $id = $this->get("no_anggota");
        if($id == ""){
            $anggota = $this->db->get("anggota")->result();
        } else {
            $this->db->where("no_anggota", $id);
            $anggota = $this->db->get("anggota")->result();
        }
        $this->response(array("result"=>$anggota, 200));
    }

    public function index_post()
    {
        $data = array(
            "no_anggota"    => $this->post("no_anggota"),
            "npm"           => $this->post("npm"),
            "nama"          => $this->post("nama"),
            "no_hp"         => $this->post("no_hp")
        );

        $insert = $this->db->insert("anggota", $data);
        if($insert){
            $this->response($data, 200);
        } else {
            $this->response(array("status" => "fail", 502));
        }
    }

    public function index_put()
    {
        $id = $this->put("no_anggota");
        $data = array(
            "no_anggota"    => $this->put("no_anggota"),
            "npm"           => $this->put("npm"),
            "nama"          => $this->put("nama"),
            "no_hp"         => $this->put("no_hp")
        );

        $this->db->where("no_anggota", $id);
        $update = $this->db->update("anggota", $data);
        if($update){
            $this->response($data, 200);
        }else{
            $this->response(array("status" => "fail", 502));
        }
    }

    public function index_delete()
    {
        $id = $this->delete("no_anggota");
        $this->db->where("no_anggota", $id);
        $delete = $this->db->delete("anggota");
        if($delete){
            $this->response(array("status" => "success"), 201);
        }else{
            $this->response(array("status" => "fail", 502));
        }
    }
}