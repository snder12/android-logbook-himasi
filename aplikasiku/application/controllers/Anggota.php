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
        $id_anggota = $this->get("id_anggota");
        if($id_anggota == ""){
            $anggota = $this->db->get("anggota")->result();
        } else {
            $this->db->where("id_anggota", $id_anggota);
            $anggota = $this->db->get("anggota")->result();
        }
        $this->response(array("result"=>$anggota, 200));
        // $response["status"] = true;
        // $response["message"] = "Anggota berhasil ditampilkan";
        // $response["data"] = $anggota;

        // $json = json_encode($response, JSON_PRETTY_PRINT);
        // echo $json;
    }

    public function index_post()
    {
        $data = array(
            "id_anggota"    => $this->post("id_anggota"),
            "npm"           => $this->post("npm"),
            "nama"          => $this->post("nama"),
            "no_hp"         => $this->post("no_hp"),
            "email"         => $this->post("email"),
            "angkatan"      => $this->post("angkatan"),
            "jabatan"       => $this->post("jabatan"),
            "level"         => $this->post("level")
        );

        $insert = $this->db->insert("anggota", $data);
        if($insert){
            $response["status"] = true;
            $response["message"] = "Registrasi berhasil";
            $response["data"] = [
                "id_anggota"    => $data["id_anggota"],
                "npm"           => $data["npm"],
                "nama"          => $data["nama"],
                "no_hp"         => $data["no_hp"],
                "email"         => $data["email"],
                "angkatan"      => $data["angkatan"],
                "jabatan"       => $data["jabatan"],
                "level"         => $data["level"]
            ];   
        } else {
            $response["status"] = false;
            $response["message"] = "Registrasi gagal";
        }
        $json = json_encode($response, JSON_PRETTY_PRINT);
        echo $json;
    }

    public function index_put()
    {
        $id = $this->put("id_anggota");
        $data = array(
            "id_anggota"    => $this->put("id_anggota"),
            "npm"           => $this->put("npm"),
            "nama"          => $this->put("nama"),
            "no_hp"         => $this->put("no_hp"),
            "email"         => $this->put("email"),
            "angkatan"      => $this->put("angkatan"),
            "jabatan"       => $this->put("jabatan")
        );

        $this->db->where("id_anggota", $id);
        $update = $this->db->update("anggota", $data);
        if($update){
            $this->response($data, 200);
        }else{
            $this->response(array("status" => "fail", 502));
        }

        // if($update){
        //     $response["status"] = true;
        //     $response["message"] = "Update berhasil";
        //     $response["data"] = [
        //         "nama" => $data["nama"],
        //         "no_hp" => $data["no_hp"],
        //         "email" => $data["email"],
        //         "angkatan" => $data["angkatan"],
        //         "jabatan" => $data["jabatan"],
        //     ];   
        // } else {
        //     $response["status"] = false;
        //     $response["message"] = "Update gagal";
        // }
        // $json = json_encode($response, JSON_PRETTY_PRINT);
        // echo $json;
    }

    public function index_delete()
    {
        $id = $this->delete("id_anggota");
        $this->db->where("id_anggota", $id);
        $delete = $this->db->delete("anggota");
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