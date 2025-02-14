package com.yedam.app.spring.xml;

public class NHCard implements Card {
	public User owner;		// 소유자
	public int payAmount;	// 결재대금

	public NHCard(User owner) {
		this.owner = owner;
		this.payAmount = 0;
	}

	@Override
	public void showOwnerInfo() {
		System.out.println(owner);
	}
	@Override
	public void payment(int pay) {
		System.out.printf("결재금액 : %d\n", pay);
		this.payAmount += pay;
		System.out.printf("결재예상일 : 15일\n결제대금 : %d\n", this.payAmount);
	}
	@Override
	public void addServices() {
		System.out.println("농협카드 부가기능");
	}
}
