<?php
require __DIR__.'/config.php';
if($_SERVER['REQUEST_METHOD']!=='POST'){http_response_code(405);exit('POST required.');}
$id=filter_input(INPUT_POST,'id',FILTER_VALIDATE_INT)?:0;
$q=$pdo->prepare('SELECT stored_name FROM student_files WHERE student_id=?');$q->execute([$id]);$stored=$q->fetchAll(PDO::FETCH_COLUMN);
$pdo->prepare('DELETE FROM students WHERE id=?')->execute([$id]);
foreach($stored as $name){$path=$uploadDir.basename($name);if(is_file($path))unlink($path);}
header('Location: index.php');exit;
