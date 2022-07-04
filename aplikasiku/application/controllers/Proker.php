<?php

defined("BASEPATH") or exit("No direct script access allowed");

require APPPATH . "/libraries/REST_Controller.php";

use Restserver\Libraries\REST_Controller;

class Proker extends REST_Controller
{
    function __construct($config = "rest")
    {
        parent::__construct($config);
        $this->load->database();
    }

    public function index_get()
    {
        $id_proker = $this->get("id_proker");
        if($id_proker == ""){
            $proker = $this->db->get("proker")->result();
        } else {
            $this->db->where("id_proker", $id_proker);
            $proker = $this->db->get("proker")->result();
        }
        $this->response(array("result"=>$proker, 200));
    }

    public function index_post()
    {
        $data = array(
            "id_proker"         => $this->post("id_proker"),
            "nama_proker"       => $this->post("nama_proker"),
            "tanggal"           => $this->post("tanggal"),
            "deskripsi"         => $this->post("deskripsi"),
        );

        $insert = $this->db->insert("proker", $data);
        if($insert){
            $response["status"] = true;
            $response["message"] = "Proker berhasil ditambahkan";
            $response["data"] = [
                "id_proker"     => $data["id_proker"],
                "nama_proker"   => $data["nama_proker"],
                "tanggal"       => $data["tanggal"],
                "deskripsi"     => $data["deskripsi"],
            ];       
        } else {
            $response["status"] = false;
            $response["message"] = "Proker gagal ditambahkan";
        }
        $json = json_encode($response, JSON_PRETTY_PRINT);
        echo $json;
    }

    public function index_put()
    {
        $id_proker = $this->put("id_proker");
        $data = array(
            "id_proker"         => $this->put("id_proker"),
            "nama_proker"       => $this->put("nama_proker"),
            "tanggal"           => $this->put("tanggal"),
            "deskripsi"         => $this->put("deskripsi"),
        );

        $this->db->where("id_proker", $id_proker);
        $update = $this->db->update("proker", $data);
        if($update){
            $response["status"] = true;
            $response["message"] = "Update berhasil";
            $response["data"] = [
                "id_proker"     => $data["id_proker"],
                "nama_proker"   => $data["nama_proker"],
                "tanggal"       => $data["tanggal"],
                "deskripsi"     => $data["deskripsi"],
            ];       
        } else {
            $response["status"] = false;
            $response["message"] = "Update gagal";
        }
        $json = json_encode($response, JSON_PRETTY_PRINT);
        echo $json;
    }

    public function index_delete()
    {
        $id_proker = $this->delete("id_proker");
        $this->db->where("id_proker", $id_proker);
        $delete = $this->db->delete("proker");
        if($delete){
            $response["status"] = true;
            $response["message"] = "Hapus data berhasil";
        }else{
            $response["status"] = false;
            $response["message"] = "Hapus data gagal";
        }
        $json = json_encode($response, JSON_PRETTY_PRINT);
        echo $json;
    }
}