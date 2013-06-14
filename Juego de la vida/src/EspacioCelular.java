import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class EspacioCelular {

	private Celula[][] poblacion;
	private int filas;
	private int columnas;
	private static int tamañoCelda = 10; // el tamaño predeterminado de las celulas

	public EspacioCelular(int filas, int columnas) {
		poblacion = new Celula[this.filas = filas][this.columnas = columnas];
		for (int i = 0; i < this.filas; i++) {
			for (int j = 0; j < this.columnas; j++) {
				poblacion[i][j] = Celula.MUERTA;
			}
		}
	}

	public void paint(Graphics g, Color c) {
		g.setColor(c);

		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				if (poblacion[i][j] == Celula.VIVA) {
					g.setColor(Color.GREEN); //Color de una celula viva
					g.fillRect(j * tamañoCelda, i * tamañoCelda, tamañoCelda,
							tamañoCelda);

				}
			}

		}

		for (int i = 0; i <= filas; i++) {
			g.setColor(c);
			g.drawLine(i, i * tamañoCelda, filas * tamañoCelda, i * tamañoCelda);
			g.drawLine(i * tamañoCelda, 0, i * tamañoCelda, columnas
					* tamañoCelda);

			g.drawLine(0, i * tamañoCelda, columnas * tamañoCelda, i
					* tamañoCelda);
			g.drawLine(i * tamañoCelda, 0, i * tamañoCelda, filas * tamañoCelda);

		}

	}

	public void setViva(int x, int y) {
		poblacion[y / tamañoCelda][x / tamañoCelda] = Celula.VIVA;

	}

	public void setMoribunda(int x, int y) {
		poblacion[y / tamañoCelda][x / tamañoCelda] = Celula.MORIBUNDA;
	}

	public void reiniciar() {
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < filas; j++) {
				poblacion[i][j] = Celula.MUERTA;
			}
		}
	}

	public void setZoom(int zoom) {

		if (zoom <= 2)
			this.tamañoCelda = 2;
		else
			this.tamañoCelda = zoom;
	}

	public int getZoom() {
		return tamañoCelda;
	}

	public void setAleatorias() {
		int cont = 0;
		Random r = new Random();
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				if (cont >= 2000)
					break;

				if (r.nextInt(200) == 0 && poblacion[i][j] == Celula.MUERTA) {
					poblacion[i][j] = Celula.EMBRION;
					cont++;
				}

			}

		}

		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				if (poblacion[i][j] == Celula.EMBRION)
					poblacion[i][j] = Celula.VIVA;
			}
		}
		cont = 0;
	}

	public void nextFase() {
		int cont;
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {

				cont = 0;

				for (int k = i -1 ; k <= i +1; k++) {
					for (int l = j -1; l <= j + 1; l++) {

						try {
							if ((k != i || l != j) && (poblacion[k][l] == Celula.VIVA || poblacion[k][l] == Celula.MORIBUNDA))
								cont++;
						}
						catch (IndexOutOfBoundsException e) {
						}
					}
				}
				if (poblacion[i][j] == Celula.VIVA && (cont <= 1 || cont >= 4))
					poblacion[i][j] = Celula.MORIBUNDA;
				else if (poblacion[i][j] == Celula.MUERTA && cont == 3) {
					poblacion[i][j] = Celula.EMBRION;
				}
				
			}
		}

		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				if (poblacion[i][j] == Celula.MORIBUNDA)
					poblacion[i][j] = Celula.MUERTA;
				else if (poblacion[i][j] == Celula.EMBRION)
					poblacion[i][j] = Celula.VIVA;

			}
		}

	}

	public void setallVivas() {
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				poblacion[i][j] = Celula.VIVA;
			}
		}
	}

	public int getEstado() {

		int vivas = 0;

		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				if (poblacion[i][j] == Celula.VIVA)
					vivas++;
			}
		}

		return vivas;
	}
}
