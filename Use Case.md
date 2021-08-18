# Use Case
* Actor: User, Server

|Actor|Actor's Goal|Use Case Name|
|-----|------------|--------------|
|User|포토지도로 볼 사진을 업로드한다.|FileUpload(UC-1)|
|Server|업로드된 파일들이 적절한 파일인지 확인한다.|ValidityCheck(UC-2)|
|Server|사진을 위치정보에 따라 지도에 표시한다.|PhotoOnMap(UC-3)|
|User|사진을 슬라이드 앨범으로 보기 위해 버튼을 클릭한다.|SlideShow(UC-4)|
|Server|사진을 슬라이드 앨범으로 시간에 따라 보여준다.|SlideShow(UC-4)|
|User|각 사진을 크게 보기 위해 클릭한다.|ClickPhoto(UC-5)|
|Server|각 사진을 크게 보여주며 시간 정보가 있으면 UC-3과 같이 슬라이드 앨범으로 보여주고 시간정보가 없으면 해당 사진만 보여준다.|ClickPhoto(UC-5)|
|User|PhotoMap 사용을 종료한다.|Exit(UC-6)|
|Server|서버에 저장된 사진 정보들을 삭제한다.|ClearInfo(UC-7)|

# Use Case Diagram
> File Upload
> </br>![fileupload (1)](https://user-images.githubusercontent.com/84883642/129917397-0c9943d3-3cbb-4316-ab0c-31c8f7594c37.jpg)

> Photo on the Map
> </br>![PhotoOnMap](https://user-images.githubusercontent.com/84883642/129917391-946bbaf1-2927-4abb-8db7-87df8c4f837b.jpg)

> Exit
> </br>![Exit](https://user-images.githubusercontent.com/84883642/129917395-57943311-516e-4231-87d3-867323f2be93.jpg)
