public class Ashe extends Champion implements RangeChampion {
// Ashe가 Champion의 것을 상속받음

    // Ashe를 위한 생성자 재설정
    public Ashe(String name) {
        // 부모(Champion)의 생성자를 가져온다.
        super(name, GameConstants.ASHE_HP, GameConstants.ASHE_AD, GameConstants.ASHE_DF);
    }

    // 스킬
    @Override
    public void useQ(Champion target){
        // 에쉬만의 Q 스킬
        System.out.println("[ " + getName() + " ]" + "이(가) " + "[ " + target.getName() + " ]" + "에게 Q스킬!");
        target.takeDamage(getAttackDamage() * 2); // 공격력의 200%
        // 주의. 이거 int라서 실수 안 됨
    }
    public void useW(Champion target){
        // 에쉬만의 W 스킬
        System.out.println("[ " + getName() + " ]" + "이(가) " + "[ " + target.getName() + " ]" + "에게 W스킬!");
        target.takeDamage(getAttackDamage() * 3); // 공격력의 300%
    }
    public void useE(Champion target){
        // 에쉬만의 E 스킬
        System.out.println("[ " + getName() + " ]" + "이(가) " + "[ " + target.getName() + " ]" + "에게 E스킬!");
        target.takeDamage(getAttackDamage() * 4);
    }
    public void useR(Champion target){
        // 에쉬만의 R 스킬
        System.out.println("[ " + getName() + " ]" + "이(가) " + "[ " + target.getName() + " ]" + "에게 R스킬!");
        target.takeDamage(getAttackDamage() * 5);
    }

    // implements champion.RangeChampion 추가했으니 오버라이드 체크
    @Override
    public void kite(){

    }

}
