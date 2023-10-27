package q3_PauloFilho;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.Scanner;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.Scanner;

public class AjusteDeBrilhoDaImagem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o caminho da imagem de entrada: ");
        String inputImagePath = scanner.nextLine();

        System.out.print("Digite o caminho da imagem de saída: ");
        String outputImagePath = scanner.nextLine();

        System.out.print("Digite o valor de ajuste de brilho (negativo para escurecer, positivo para clarear): ");
        int brilhoAdjust = scanner.nextInt();

        try {
            BufferedImage imagem = ImageIO.read(new File(inputImagePath));
            ajustarBrilho(imagem, brilhoAdjust);
            ImageIO.write(imagem, "jpg", new File(outputImagePath));

            System.out.println("Ajuste de brilho concluído. Imagem salva em " + outputImagePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void ajustarBrilho(BufferedImage imagem, int ajuste) {
        int largura = imagem.getWidth();
        int altura = imagem.getHeight();

        for (int y = 0; y < altura; y++) {
            for (int x = 0; x < largura; x++) {
                int rgb = imagem.getRGB(x, y);

                int r = (rgb >> 16) & 0xFF;
                int g = (rgb >> 8) & 0xFF;
                int b = rgb & 0xFF;

                // Ajustar o valor de brilho
                r = clamp(r + ajuste);
                g = clamp(g + ajuste);
                b = clamp(b + ajuste);

                int novoRGB = (r << 16) | (g << 8) | b;
                imagem.setRGB(x, y, novoRGB);
            }
        }
    }

    public static int clamp(int valor) {
        return Math.min(255, Math.max(0, valor));
    }
}

