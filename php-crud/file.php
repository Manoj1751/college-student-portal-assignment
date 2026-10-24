<?php
require __DIR__.'/config.php';
$id=filter_input(INPUT_GET,'id',FILTER_VALIDATE_INT)?:0;
$q=$pdo->prepare('SELECT * FROM student_files WHERE id=?');$q->execute([$id]);$f=$q->fetch();
if(!$f){http_response_code(404);exit('File not found.');}
$path=$uploadDir.basename($f['stored_name']);if(!is_file($path)){http_response_code(404);exit('Stored file is missing.');}
header('X-Content-Type-Options: nosniff');header('Content-Type: '.$f['file_type']);header('Content-Disposition: inline; filename="'.rawurlencode($f['original_name']).'"');header('Content-Length: '.filesize($path));readfile($path);
