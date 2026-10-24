<?php
$dbHost='127.0.0.1'; $dbName='student_portal'; $dbUser='root'; $dbPass='';
$uploadDir=__DIR__.'/uploads/';
if(!is_dir($uploadDir)) mkdir($uploadDir,0750,true);
try{$pdo=new PDO("mysql:host={$dbHost};dbname={$dbName};charset=utf8mb4",$dbUser,$dbPass,[PDO::ATTR_ERRMODE=>PDO::ERRMODE_EXCEPTION,PDO::ATTR_DEFAULT_FETCH_MODE=>PDO::FETCH_ASSOC,PDO::ATTR_EMULATE_PREPARES=>false]);}catch(PDOException $e){http_response_code(500);exit('Database connection failed. Check config.php and confirm MySQL is running.');}
function h($value):string{return htmlspecialchars((string)$value,ENT_QUOTES|ENT_SUBSTITUTE,'UTF-8');}
