# nix-5-offline-proj

#Реализуйте библиотеку reversestring.jar
Основная цель библиотеки - расширить метод reverse классов
StringBuilder/Buffer.
Вы должны предоставить пользователю набор методов, которые умеют:
- обычный реверс
- реверс по указанной подстроке в строке
- весь этот функционал + пользователь может указать, с какого символа,
  индекса, строки или CharSequnce начать/закончить
  примеры:
  public static String reverse(String src);
  -> hello world
  <- olleh dlrow
  public static String reverse(String src, String dest);
  -> hello world, worl
  <- hello lrowd
  public static String reverse(String src, int firstIndex, int
  lastIndex);
  -> hello world, 3, 7
  <- helol owrld
  ИСПОЛЬЗОВАНИЕ коробочного reverse запрещено!
