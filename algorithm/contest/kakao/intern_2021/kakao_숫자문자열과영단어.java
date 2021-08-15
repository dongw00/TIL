package contest.kakao.intern_2021;

public class kakao_숫자문자열과영단어 {

    public static void main(String[] args) {
        System.out.println(solution("one4seveneight"));
        System.out.println(solution("23four5six7"));
        System.out.println(solution("1zerotwozero3"));
    }

    public static int solution(String s) {
        s = s
            .replaceAll("zero", "0")
            .replaceAll("one", "1")
            .replaceAll("two", "2")
            .replaceAll("three", "3")
            .replaceAll("four", "4")
            .replaceAll("five", "5")
            .replaceAll("six", "6")
            .replaceAll("seven", "7")
            .replaceAll("eight", "8")
            .replaceAll("nine", "9");

        return Integer.parseInt(s);
    }
}
