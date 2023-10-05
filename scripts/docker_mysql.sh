docker run \
  --name selenium-mysql \
  -e MYSQL_ROOT_PASSWORD=password \
  -p 3307:3306 \
  -d \
  mysql:8.0.31
#  -v /my/custom:/etc/mysql/conf.d \
