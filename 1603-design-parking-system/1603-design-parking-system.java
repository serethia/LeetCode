class ParkingSystem {
    // 확장하는 연습: 불변하도록 private final 처리 + 배열보단 map 활용
    // 아직 타입이 생성자에 고정되어서 완벽한 확장 코드는 아님 
    // => "생성자 수정" + "enum 활용" 필요!

    // * enum: 의미있는 상수 집합 (클래스 바깥에 정의. 값은 대문자로)
    // 예를 들어, ParkingSystem 클래스 바깥에
    // enum Car {
    //     BIG, MEDIUM, SMALL
    // } 를 추가한 후
    // HashMap<Car, Integer>로 바꾼다

    // * 생성자는 함수에서 직접 변경할 private final Map<Car, Integer> map; 으로 써서 만든 뒤
    // public '클래스명'(Map<Car, Integer> input){
    //     this.map = new HashMap<>(input);
    // } 로 실제 입력값 map인 input의 복제 map인 map 생성
    // 이 map에 enum을 key로 해서 활용한다
    // map.put(Car.BIG, big); 처럼 작성한다

    private final Map<Integer, Integer> map;
    private final int Big = 1;
    private final int Medium = 2;
    private final int Small = 3;

    public ParkingSystem(int big, int medium, int small) {
        map = new HashMap<>();
        // 직접 1,2,3으로 key를 쓰기보다 final int(확장 시 enum인 Car에서 Car.BIG, Car.MEDIUM, Car.SMALL)를 key로 활용
        map.put(Big, big);
        map.put(Medium, medium);
        map.put(Small, small);
    }

    public boolean addCar(int carType) {
        int able = map.getOrDefault(carType, 0);
        // 불가능한 경우를 먼저 return: 가독성 up!
        if (able <= 0) {
            return false;
        }
        map.put(carType, (able - 1));
        return true;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */