package com.yedam.app.spring.javabase;

public interface Card {
   // 소유자 정보
   public void showOwnerInfo();
   // 결제기능
   public void payment(int pay);
   // 부가기능
   public void addServices();
}
