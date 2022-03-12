package com.bai_tap.model;

public class Medical {
    private String fullName;
    private  int birthday;
    private boolean gender;
    private String national;
    private String idCard;
    private String travelInformation; // thông tin đi lại.
    private String vehicleNumber; //số hiệu phương tiện
    private String numberOfSeat;// số ghế
    private String startDay;
    private String endDay;
    private String twoWeeksInformation; //thông tin di chuyển trong vòng 2 tuần
    private String provinceCity; //tỉnh, thành phố
    private String district; //quận, huyện
    private String wardCommune; //phường, xã
    private String address;
    private String phone;
    private String email;
    private boolean fever; // sốt
    private boolean cough; // ho
    private boolean shortnessOfBreath; // khó thở
    private boolean soreThroat; // đau họng
    private boolean nausea; // buồn nôn
    private boolean diarrhea; //tieu chay
    private boolean skinBleeding; //xuất huyết ngoài da
    private boolean skinRash; // nổi ban ngoài da
    private boolean contactCovid; //tiếp xúc với người nhiễm covid
    private boolean contactAnimals; //tiếp xúc với động vật

    public Medical() {
    }

    public Medical(String fullName, int birthday,
                   boolean gender, String national,
                   String idCard, String travelInformation,
                   String vehicleNumber, String numberOfSeat,
                   String startDay, String endDay,
                   String twoWeeksInformation, String provinceCity,
                   String district, String wardCommune,
                   String address, String phone,
                   String email, boolean fever,
                   boolean cough, boolean shortnessOfBreath,
                   boolean soreThroat, boolean nausea,
                   boolean diarrhea, boolean skinBleeding,
                   boolean skinRash, boolean contactCovid, boolean contactAnimals) {
        this.fullName = fullName;
        this.birthday = birthday;
        this.gender = gender;
        this.national = national;
        this.idCard = idCard;
        this.travelInformation = travelInformation;
        this.vehicleNumber = vehicleNumber;
        this.numberOfSeat = numberOfSeat;
        this.startDay = startDay;
        this.endDay = endDay;
        this.twoWeeksInformation = twoWeeksInformation;
        this.provinceCity = provinceCity;
        this.district = district;
        this.wardCommune = wardCommune;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.fever = fever;
        this.cough = cough;
        this.shortnessOfBreath = shortnessOfBreath;
        this.soreThroat = soreThroat;
        this.nausea = nausea;
        this.diarrhea = diarrhea;
        this.skinBleeding = skinBleeding;
        this.skinRash = skinRash;
        this.contactCovid = contactCovid;
        this.contactAnimals = contactAnimals;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getBirthday() {
        return birthday;
    }

    public void setBirthday(int birthday) {
        this.birthday = birthday;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getTravelInformation() {
        return travelInformation;
    }

    public void setTravelInformation(String travelInformation) {
        this.travelInformation = travelInformation;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getNumberOfSeat() {
        return numberOfSeat;
    }

    public void setNumberOfSeat(String numberOfSeat) {
        this.numberOfSeat = numberOfSeat;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public String getTwoWeeksInformation() {
        return twoWeeksInformation;
    }

    public void setTwoWeeksInformation(String twoWeeksInformation) {
        this.twoWeeksInformation = twoWeeksInformation;
    }

    public String getProvinceCity() {
        return provinceCity;
    }

    public void setProvinceCity(String provinceCity) {
        this.provinceCity = provinceCity;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getWardCommune() {
        return wardCommune;
    }

    public void setWardCommune(String wardCommune) {
        this.wardCommune = wardCommune;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isFever() {
        return fever;
    }

    public void setFever(boolean fever) {
        this.fever = fever;
    }

    public boolean isCough() {
        return cough;
    }

    public void setCough(boolean cough) {
        this.cough = cough;
    }

    public boolean isShortnessOfBreath() {
        return shortnessOfBreath;
    }

    public void setShortnessOfBreath(boolean shortnessOfBreath) {
        this.shortnessOfBreath = shortnessOfBreath;
    }

    public boolean isSoreThroat() {
        return soreThroat;
    }

    public void setSoreThroat(boolean soreThroat) {
        this.soreThroat = soreThroat;
    }

    public boolean isNausea() {
        return nausea;
    }

    public void setNausea(boolean nausea) {
        this.nausea = nausea;
    }

    public boolean isDiarrhea() {
        return diarrhea;
    }

    public void setDiarrhea(boolean diarrhea) {
        this.diarrhea = diarrhea;
    }

    public boolean isSkinBleeding() {
        return skinBleeding;
    }

    public void setSkinBleeding(boolean skinBleeding) {
        this.skinBleeding = skinBleeding;
    }

    public boolean isSkinRash() {
        return skinRash;
    }

    public void setSkinRash(boolean skinRash) {
        this.skinRash = skinRash;
    }

    public boolean isContactCovid() {
        return contactCovid;
    }

    public void setContactCovid(boolean contactCovid) {
        this.contactCovid = contactCovid;
    }

    public boolean isContactAnimals() {
        return contactAnimals;
    }

    public void setContactAnimals(boolean contactAnimals) {
        this.contactAnimals = contactAnimals;
    }

    @Override
    public String toString() {
        return "Medical{" +
                "fullName='" + fullName + '\'' +
                ", birthday=" + birthday +
                ", gender=" + gender +
                ", national='" + national + '\'' +
                ", idCard='" + idCard + '\'' +
                ", travelInformation='" + travelInformation + '\'' +
                ", vehicleNumber='" + vehicleNumber + '\'' +
                ", numberOfSeat='" + numberOfSeat + '\'' +
                ", startDay='" + startDay + '\'' +
                ", endDay='" + endDay + '\'' +
                ", twoWeeksInformation='" + twoWeeksInformation + '\'' +
                ", provinceCity='" + provinceCity + '\'' +
                ", district='" + district + '\'' +
                ", wardCommune='" + wardCommune + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", fever=" + fever +
                ", cough=" + cough +
                ", shortnessOfBreath=" + shortnessOfBreath +
                ", soreThroat=" + soreThroat +
                ", nausea=" + nausea +
                ", diarrhea=" + diarrhea +
                ", skinBleeding=" + skinBleeding +
                ", skinRash=" + skinRash +
                ", contactCovid=" + contactCovid +
                ", contactAnimals=" + contactAnimals +
                '}';
    }
}
