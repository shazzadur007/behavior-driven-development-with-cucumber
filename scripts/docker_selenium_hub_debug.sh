#!/usr/bin/env bash

#docker run -d -p 4545:4444 --name selenium-hub-debug selenium/hub

#docker run -d -P --link selenium-hub-debug:hub selenium/node-firefox-debug

#docker run -d -P --link selenium-hub-debug:hub selenium/node-chrome-debug

#docker run -d -p 4446:4444 -p 5902:5900 --shm-size="2g" selenium/standalone-firefox:4.6.0-20221104

#docker network create grid
#docker run -d -p 4442-4444:4442-4444 --net grid --name selenium-hub selenium/hub:4.6.0-20221104
#docker run -d -p 5901:5900 --net grid -e SE_EVENT_BUS_HOST=selenium-hub \
#    --shm-size="2g" \
#    -e SE_EVENT_BUS_PUBLISH_PORT=4442 \
#    -e SE_EVENT_BUS_SUBSCRIBE_PORT=4443 \
#    selenium/node-chrome:4.6.0-20221104
#docker run -d -p 5902:5900 --net grid -e SE_EVENT_BUS_HOST=selenium-hub \
#    --shm-size="2g" \
#    -e SE_EVENT_BUS_PUBLISH_PORT=4442 \
#    -e SE_EVENT_BUS_SUBSCRIBE_PORT=4443 \
#    selenium/node-edge:4.6.0-20221104
docker run -d -p 5903:5900 --net grid -e SE_EVENT_BUS_HOST=selenium-hub \
    --shm-size="2g" \
    -e SE_EVENT_BUS_PUBLISH_PORT=4442 \
    -e SE_EVENT_BUS_SUBSCRIBE_PORT=4443 \
    -v /Users/r_hasan/Desktop/admin_panel_automation/firefox_data_dir/:/tmp/firefox_data_dir \
    selenium/node-firefox:4.6.0-20221104