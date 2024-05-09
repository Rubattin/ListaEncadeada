package com.mycompany.manipulacaodelistas;

import java.util.Scanner;

class Lista {
    private No primeiro;

    public Lista() {
        this.primeiro = null;
    }
    

    public void inserirNoInicio(int valor) {
        No novoNo = new No(valor);
        novoNo.proximo = primeiro;
        primeiro = novoNo;
    }
    

    public void inserirNoFim(int valor) {
        No novoNo = new No(valor);
        if (primeiro == null) {
            primeiro = novoNo;
            return;
        }
        No atual = primeiro;
        while (atual.proximo != null) {
            atual = atual.proximo;
        }
        atual.proximo = novoNo;
    }
    
    
    public void inserirPorPosicao(int valor, int posicao) {
        if (posicao < 0) {
            System.out.println("Posicao invalida.");
            return;
        }

        No novoNo = new No(valor);

        if (posicao == 0) {
            novoNo.proximo = primeiro;
            primeiro = novoNo;
            return;
        }

        No anterior = null;
        No atual = primeiro;
        int cont = 0;

        while (atual != null && cont < posicao) {
            anterior = atual;
            atual = atual.proximo;
            cont++;
        }

        if (cont == posicao) {
            anterior.proximo = novoNo;
            novoNo.proximo = atual;
        } else {
            System.out.println("Posicao invalida. O elemento na ofoi inserido.");
        }
    }

    

    public boolean buscarElemento(int valor) {
        No atual = primeiro;
        while (atual != null) {
            if (atual.valor == valor) {
                return true;
            }
            atual = atual.proximo;
        }
        return false;
    }
    

    public void imprimirLista() {
        No atual = primeiro;
        while (atual != null) {
            System.out.print(atual.valor + " -> ");
            atual = atual.proximo;
        }
        System.out.println("null");
    }
    
    
    public void removerElemento(int valor, int opcao) {
        if (primeiro == null) {
            System.out.println("Lista vazia. Nao ha elementos para remover.");
            return;
        }
        switch (opcao) {
            case 1: 
                if (primeiro.valor == valor) {
                    primeiro = primeiro.proximo;
                    System.out.println("Elemento " + valor + " removido do inicio da lista.");
                } else {
                    System.out.println("Elemento " + valor + " nao encontrado no inicio da lista.");
                }
                break;
            case 2: 
                No anterior = null;
                No atual = primeiro;
                while (atual.proximo != null) {
                    anterior = atual;
                    atual = atual.proximo;
                }
                if (atual.valor == valor) {
                    if (anterior == null) {
                        primeiro = null;
                    } else {
                        anterior.proximo = null;
                    }
                    System.out.println("Elemento " + valor + " removido do fim da lista.");
                } else {
                    System.out.println("Elemento " + valor + " não encontrado no fim da lista.");
                }
                break;
            case 3: 
                No anteriorPorValor = null;
                No atualPorValor = primeiro;
                while (atualPorValor != null && atualPorValor.valor != valor) {
                    anteriorPorValor = atualPorValor;
                    atualPorValor = atualPorValor.proximo;
                }
                if (atualPorValor != null) {
                    if (anteriorPorValor == null) {
                        primeiro = atualPorValor.proximo;
                    } else {
                        anteriorPorValor.proximo = atualPorValor.proximo;
                    }
                    System.out.println("Elemento " + valor + " removido da lista.");
                } else {
                    System.out.println("Elemento " + valor + " nao encontrado na lista.");
                }
                break;
            default:
                System.out.println("Opcao invalida para remocao.");
        }
    }

}
