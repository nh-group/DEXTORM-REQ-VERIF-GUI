.DEFAULT: all

all: clean clean-docker build build-docker

build:
	mvn  package
	
build-docker: 
	docker build . -t nherbaut/dextorm-gui

clean:
	mvn clean

clean-docker: 
	docker rmi -f nherbaut/dextorm-gui

run:
	docker run -p 8080:8080  nherbaut/dextorm-gui

push-docker:
	docker push nherbaut/dextorm-gui
