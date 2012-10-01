package be.technobel.domain.datamodel;



public class PlayerToken {

		Token token;
		boolean reversed=false;
		String imageUrl;
		Player owner;
		
		public PlayerToken(Token token,Player owner)
		{
			this.token=token;
			this.owner=owner;
			this.imageUrl=token.getImageFront();
		}

		public Token getToken() {
			return token;
		}

		public boolean isReversed() {
			return reversed;
		}

		public void setReversed(boolean reversed) {
			this.reversed = reversed;
			this.imageUrl = (reversed) ? token.getImageBack() : token.getImageFront();
		}

		public Player getOwner() {
			return owner;
		}

		public void setOwner(Player owner) {
			this.owner = owner;
		}
		
		
}
