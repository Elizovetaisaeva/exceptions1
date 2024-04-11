package com.example.exceptions1.myexceptions;

public class Main {
    private static final String REGEX = "^ [a-zA-Z0-9_]*$";
    private static final String ALLOWED_CHARS = "qwertyuiopasdfghjklzxcvbnmQWERTYIOPASDFGHJKLZXCVBNM_";

    public static void main(String[] args) {
        try {

            check("admin-", "123", "123");
            System.out.println("Проверка пройдина");
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void check(String login, String password,
                             String confirmPassword) {
        if (!login.matches(REGEX)) {
            throw new WrongLoginException("В логине есть запрещенный символ");
        }
        if (login.length() > 20) {
            throw new WrongLoginException("Длина логина больше 20 символов");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совподают");
        }

        if (password.length() > 20) {
            throw new WrongPasswordException("Длина логина больше 20 символов");
        }
        if (!isStringCorrect(password)) {
            throw new WrongPasswordException("Пароль содержит некорректные символы");

        }

    }

    private static boolean isStringCorrect(String str) {
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (('a' <= ch && ch <= 'z')
                    || ('A' <= ch && ch <= 'Z')
                    || ('0' <= ch && ch <= '9')
                    || (ch == '_')) {
                continue;
            } else {
                return false;
            }

        }
        return true;

    }

    private static boolean isStringCorrect2(String str) {
        for (int i = 0; i < str.length(); i++) {
        }


        return false;
    }
}

